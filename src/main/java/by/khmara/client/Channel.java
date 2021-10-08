package by.khmara.client;

import by.khmara.article.Article;

public interface Channel {

    void accept(Article article);
}
