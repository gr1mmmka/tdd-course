package by.khmara.sender;

import by.khmara.article.Article;
import by.khmara.client.Channel;
import by.khmara.database.ArticleDataAccess;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDistributor {
    private Channel sport;
    private Channel entertainment;
    private Channel finance;
    private ArticleDataAccess dataAccess;

    public void distributeArticles() {
        for (Article article : dataAccess.getAllArticles()) {
            switch (article.getType()) {
                case SPORT -> {
                    sport.accept(article);
                    break;
                }
                case ENTERTAINMENT -> {
                    entertainment.accept(article);
                    break;
                }
                case FINANCE -> {
                    finance.accept(article);
                    break;
                }
            }
        }

    }
}
