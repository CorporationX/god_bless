package faang.school.godbless.BJS2_20300;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends Main {
    private Main main;
    private WebPage webPage1;

    @BeforeEach
    void setUp() {
        main = new Main();
        webPage1 = new WebPage("http://www.webPage1.com", "MyWebPage1", "This is New page");
        main.indexationNewWebPage(webPage1);
    }

    @Test
    void testIndexationNewWebPage() {
        WebPage webPage2 = new WebPage("http://www.webPage2.com", "MyWebPage2", "Again page");
        main.indexationNewWebPage(webPage2);
        List<WebPage> searchResults = main.findWebPage("again");
        assertTrue(searchResults.contains(webPage2));
    }

    @Test
    void testFindWebPage() {
        List<WebPage> searchResults = main.findWebPage("new");
        assertTrue(searchResults.contains(webPage1));
    }

    @Test
    void testRemoveWebPage() {
        main.removeWebPage(webPage1.getUrl());
        assertFalse(main.getWordsPages().containsKey(webPage1));
    }
}