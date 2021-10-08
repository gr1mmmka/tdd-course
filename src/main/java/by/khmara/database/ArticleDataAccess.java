package by.khmara.database;

import by.khmara.article.Article;

import java.util.List;

public interface ArticleDataAccess {

    List<Article> getAllArticles();
}
