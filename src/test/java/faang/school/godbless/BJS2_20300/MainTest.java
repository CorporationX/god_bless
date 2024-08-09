package faang.school.godbless.BJS2_20300;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private WebPage webPageOne;

    @BeforeEach
    void setUp() {
        main = new Main();
        webPageOne = new WebPage("http://www.webPage1.com", "MyWebPage1", "This is New page");
        main.indexationNewWebPage(webPageOne);
    }

    @Test
    void testIndexationNewWebPage() {
        WebPage webPageTwo = new WebPage("http://www.webPage2.com", "MyWebPage2", "Again page");
        main.indexationNewWebPage(webPageTwo);
        List<WebPage> searchResults = main.findWebPage("again");
        assertTrue(searchResults.contains(webPageTwo));
    }

    @Test
    void testFindWebPage() {
        List<WebPage> searchResults = main.findWebPage("new");
        assertTrue(searchResults.contains(webPageOne));
    }

    @Test
    void testRemoveWebPage() {
        main.removeWebPage(webPageOne.getUrl());
        assertFalse(main.getWordsPages().containsKey(webPageOne));
    }
}