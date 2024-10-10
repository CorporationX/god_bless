package school.faang.googleminisearchengine.webpage;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebPageServiceTest {

    @Test
    void deleteWebPageFromIndex() {
        String content = "Word1";
        String url = "www.url1.com/superpage/1";
        String title = "webPage1";

        WebPage webPage = new WebPage(url, title, content);

        WebPageService.indexWebPage(webPage);
        assertEquals(WebPageService.searchByWord("Word1"), List.of(webPage));

        WebPageService.removeWebPageByUrl(webPage.getUrl());
        assertEquals(WebPageService.searchByWord("Word1"), List.of());
    }

    @Test
    void findByWord() {
        String content = "Word1, word2, Word3, wor-D4. Word-5!";
        String url = "www.url1.com/superpage/1";
        String title = "webPage1";

        WebPage webPage = new WebPage(url, title, content);

        WebPageService.indexWebPage(webPage);

        assertEquals(WebPageService.searchByWord("Word1"), List.of(webPage));
        assertEquals(WebPageService.searchByWord("word1"), List.of(webPage));
        assertEquals(WebPageService.searchByWord("wor-D4"), List.of(webPage));
        assertEquals(WebPageService.searchByWord("word6"), List.of());

        WebPageService.removeWebPageByUrl(webPage.getUrl());
    }

    @Test
    void multiWebPagesToIndex() {
        String content1 = "Word1, word2, Word3, wor-D4. Word-5!";
        String url1 = "www.url1.com/superpage/1";
        String title1 = "webPage1";

        WebPage webPage1 = new WebPage(url1, title1, content1);
        WebPageService.indexWebPage(webPage1);
        assertEquals(WebPageService.searchByWord("Word1"), List.of(webPage1));
        assertEquals(WebPageService.searchByWord("word6"), List.of());

        String content2 = "Word6, Word-7! Word2.";
        String url2 = "www.url1.com/superpage/2";
        String title2 = "webPage2";

        WebPage webPage2 = new WebPage(url2, title2, content2);
        WebPageService.indexWebPage(webPage2);
        assertEquals(WebPageService.searchByWord("Word1"), List.of(webPage1));
        assertEquals(WebPageService.searchByWord("word6"), List.of(webPage2));
        assertEquals(WebPageService.searchByWord("word2"), List.of(webPage1, webPage2));

        WebPageService.removeWebPageByUrl(webPage1.getUrl());
        WebPageService.removeWebPageByUrl(webPage2.getUrl());
    }
}
