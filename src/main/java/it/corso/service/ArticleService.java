package it.corso.service;
import java.util.List;
import it.corso.dto.ArticleDto;
import it.corso.model.Article;

public interface ArticleService
{
	void articleRegistration(Article article);
	List<ArticleDto> getArticles();
	ArticleDto getArticleByCode(String code);
}