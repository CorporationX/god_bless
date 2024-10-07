package school.faang.BJS2_32846_MiniGoogleService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebServiceTest {
    WebService webService;

    WebPage page1;
    WebPage page2;
    WebPage page3;

    @BeforeEach
    void setUp() {
        webService = new WebService();

        page1 = new WebPage("http://example.com/page1", "Example Page 1", "This is an example content with keywords.");
        page2 = new WebPage("http://example.com/page2", "Example Page 2", "Another example with different keywords.");
        page3 = new WebPage("http://example.com/page3", "Example Page 3", "Keywords and more keywords.");
    }

    @Test
    @DisplayName("Testing indexing pages")
    void testIndexPages() {
        webService.indexWebPage(page1);
        webService.indexWebPage(page2);
        webService.indexWebPage(page3);

        assertEquals(11, webService.getWordsCount());
    }

    @Test
    @DisplayName("Testing getting list of pages by word on them")
    void testGetPages() {
        webService.indexWebPage(page1);
        webService.indexWebPage(page2);
        webService.indexWebPage(page3);

        assertEquals(3, webService.getWebPages("keywords").size());
        assertEquals(2, webService.getWebPages("example").size());
        assertEquals(1, webService.getWebPages("this").size());
    }

    @Test
    @DisplayName("Testing removing the page from index by its url")
    void testRemovePageByUrl() {
        webService.indexWebPage(page1);
        webService.indexWebPage(page2);
        webService.indexWebPage(page3);

        webService.removeWebPage(page2.getUrl());

        assertEquals(9, webService.getWordsCount());
    }

}