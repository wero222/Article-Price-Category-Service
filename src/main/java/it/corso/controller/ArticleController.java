package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.corso.dto.ArticleDto;
import it.corso.model.Article;
import it.corso.service.ArticleService;

@RestController
@RequestMapping("/api/article")
public class ArticleController
{
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private PriceService priceService;
	
	// endpoint #1: registrazione articolo  localhost:8051/api/article/add
	@PostMapping("/add")
	public void articleRegistration(@RequestBody Article article)
	{
		articleService.articleRegistration(article);
	}
	
	// endpoint #2: elenco articoli  localhost:8051/api/article/get
	@GetMapping("/get")
	public List<ArticleDto> getArticles()
	{
		List<ArticleDto> articles = articleService.getArticles();
		System.out.println("stampa dati");
		articles.forEach(a -> a.setPrice(priceService.getArticlePrice(a.getArtCode())));
		return articles;
	}
	
	// endpoint #3: dati articolo per codice  localhost:8051/api/article/getbycode/{article code}
	@GetMapping("/getbycode/{code}")
	public ArticleDto getArticleByCode(@PathVariable("code") String code)
	{
		ArticleDto article = articleService.getArticleByCode(code);
		System.out.println("stampa dati");
		article.setPrice(priceService.getArticlePrice(article.getArtCode()));
		return article;
	}
}