package by.khmara.sender;

import by.khmara.article.Article;
import by.khmara.article.Type;
import by.khmara.client.Channel;
import by.khmara.database.ArticleDataAccess;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ArticleDistributorTest {
    @Mock
    private Channel finance;
    @Mock
    private Channel entertainment;
    @Mock
    private Channel sport;
    @Mock
    ArticleDataAccess dataAccess;
    @InjectMocks
    private ArticleDistributor distributor;

    @Test
    void sportGoesSportsFinanceGoesFinances() {
        //given list of articles from database
        List<Article> articles = asList(
                new Article("The news about entertainment", Type.ENTERTAINMENT),
                new Article("The news about finance", Type.FINANCE));

        //when we distribute
        distributor.distributeArticles();

        when(dataAccess.getAllArticles()).thenReturn(articles);

        //then one goes to the SPORT and one goes to the FINANCE
        verify(finance).accept(any());
        verify(entertainment).accept(any());
        verify(sport, never()).accept(any());
    }

}