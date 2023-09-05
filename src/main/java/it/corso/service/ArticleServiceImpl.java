package it.corso.service;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import it.corso.dao.ArticleDao;
import it.corso.dto.ArticleDto;
import it.corso.model.Article;

@Service
@CacheConfig(cacheNames = {"articles"})
public class ArticleServiceImpl implements ArticleService
{
	@Autowired
	private ArticleDao articleDao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Caching
	(
			evict = 
							{
									@CacheEvict(cacheNames = "articles", allEntries = true),
									@CacheEvict(cacheNames = "artcode", key = "#article.artCode")
							}
	)
	@Override
	public void articleRegistration(Article article)
	{
		articleDao.save(article);
	}

	@Cacheable
	@Override
	public List<ArticleDto> getArticles()
	{
		List<Article> articles = (List<Article>) articleDao.findAll();
		List<ArticleDto> articlesDto = new ArrayList<>();
		articles.forEach(a -> articlesDto.add(mapper.map(a, ArticleDto.class)));
		return articlesDto;
	}

	@Cacheable(value = "artcode", key = "#code", sync = true)
	@Override
	public ArticleDto getArticleByCode(String code)
	{
		Article article = articleDao.findByArtCode(code);
		return mapper.map(article, ArticleDto.class);
	}
}