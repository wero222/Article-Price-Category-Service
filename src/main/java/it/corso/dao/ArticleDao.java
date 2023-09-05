package it.corso.dao;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Article;

public interface ArticleDao extends CrudRepository<Article, Integer>
{
	Article findByArtCode(String code);
}