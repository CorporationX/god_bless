package googles_mini_search_engine;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void indexPage() {
        WebPage webPage = new WebPage("https://www.google.com", "Google", "Search engine");

        Main.indexPage(webPage);

        assertEquals(4, Main.getWebPages().size());

        Main.removePage(webPage);
    }

    @Test
    void search() {
        WebPage webPage = new WebPage("https://www.bing.com", "Bing", "Test search domain");

        Main.indexPage(webPage);

        assertEquals(1, Main.search("domain").size());

        Main.removePage(webPage);
    }

    @Test
    void removePage() {
        WebPage webPage = new WebPage("https://www.yahoo.com", "Yahoo", "Technical search engine");

        Main.indexPage(webPage);

        assertEquals(5, Main.getWebPages().size());

        Main.removePage(webPage);

        List<WebPage> webPages = Main.search("technical");

        assertEquals(0, webPages.size());
    }
}