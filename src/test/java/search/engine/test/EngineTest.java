package search.engine.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import search.engine.Main;
import search.engine.WebPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTest {
    @BeforeEach
    void setUp() {
        Main.getIndexMap().clear();
    }

    @Test
    @DisplayName("Testing add page to index")
    void engineTest_addToIndex() {
        try {
            URL url = new URI("http://baeldung.com").toURL();
            WebPage webPage = new WebPage(url, "test", "test");

            Main.addPageToIndex(webPage);

            assertAll(
                    () -> assertTrue(Main.getIndexMap().containsKey("test")),
                    () -> assertTrue(Main.getIndexMap().get("test").contains(webPage)),
                    () -> assertEquals(1, Main.getIndexMap().size())
            );
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }

    @Test
    @DisplayName("Testing add several pages with several words in content")
    void engineTest_addToIndexPagesWithMoreWords() {
        try {
            URL url1 = new URI("http://baeldung.com").toURL();
            WebPage webPage1 = new WebPage(url1, "test", "test, test1, test2");
            WebPage webPage2 = new WebPage(url1, "test", "test1, test2");

            Main.addPageToIndex(webPage1);
            Main.addPageToIndex(webPage2);

            assertAll(
                    () -> assertTrue(Main.getIndexMap().containsKey("test")),
                    () -> assertTrue(Main.getIndexMap().containsKey("test1")),
                    () -> assertTrue(Main.getIndexMap().containsKey("test2")),
                    () -> assertTrue(Main.getIndexMap().get("test").contains(webPage1)),
                    () -> assertTrue(Main.getIndexMap().get("test1").contains(webPage1)),
                    () -> assertTrue(Main.getIndexMap().get("test2").contains(webPage1)),
                    () -> assertTrue(Main.getIndexMap().get("test1").contains(webPage2)),
                    () -> assertTrue(Main.getIndexMap().get("test2").contains(webPage2)),
                    () -> assertEquals(3, Main.getIndexMap().size())
            );
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }

    @Test
    @DisplayName("Testing add wepbage with empty content")
    void engineTest_addPageWithEmptyContent() {
        try {
            URL url = new URI("http://baeldung.com").toURL();
            WebPage webPage = new WebPage(url, "test", "");

            Main.addPageToIndex(webPage);

            assertTrue(Main.getIndexMap().isEmpty());
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }

    @Test
    @DisplayName("Testing add null webpage to index")
    void engineTest_addNullPageToIndex() {
        assertThrows(NullPointerException.class, () -> Main.addPageToIndex(null));
    }

    @Test
    @DisplayName("Testing get list of pages by keyword")
    void engineTest_getPagesByKeyWord() {
        try {
            URL url1 = new URI("http://baeldung.com").toURL();
            WebPage webPage1 = new WebPage(url1, "test", "test, test1, test2");
            WebPage webPage2 = new WebPage(url1, "test", "test1, test2");
            Main.addPageToIndex(webPage1);
            Main.addPageToIndex(webPage2);

            var result = Main.getPagesByKeyWord("test1");

            assertAll(
                    () -> assertNotNull(result),
                    () -> assertTrue(result.contains(webPage1)),
                    () -> assertTrue(result.contains(webPage2))
            );
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }

    @Test
    @DisplayName("Testing get list of pages by keyword not in the map")
    void engineTest_getPagesByKeyWordNotInMap() {
        try {
            URL url1 = new URI("http://baeldung.com").toURL();
            WebPage webPage1 = new WebPage(url1, "test", "test, test1, test2");
            Main.addPageToIndex(webPage1);

            var result = Main.getPagesByKeyWord("test3");

            assertNull(result);
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }

    @Test
    @DisplayName("Testing get list of pages by null keyword")
    void engineTest_getPagesByNullKeyWord() {
        assertThrows(NullPointerException.class, () -> Main.getPagesByKeyWord(null));
    }

    @Test
    @DisplayName("Testing remove page from index")
    void engineTest_removePage() {
        try {
            URL url1 = new URI("http://baeldung.com").toURL();
            URL url2 = new URI("https://docs.oracle.com/javase/8/docs/api/overview-summary.html").toURL();
            WebPage webPage1 = new WebPage(url1, "test", "test, test1, test2");
            WebPage webPage2 = new WebPage(url2, "test", "test1, test2");
            Main.addPageToIndex(webPage1);
            Main.addPageToIndex(webPage2);

            Main.removeFromIndexByURL(url1);

            assertAll(
                    () -> assertEquals(2, Main.getIndexMap().size()),
                    () -> assertFalse(Main.getPagesByKeyWord("test1").contains(webPage1)),
                    () -> assertFalse(Main.getPagesByKeyWord("test2").contains(webPage1))
            );
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }

    @Test
    @DisplayName("Testing remove page from index by URL not in index")
    void engineTest_removePageWithURLNotInIndex() {
        try {
            URL url1 = new URI("http://baeldung.com").toURL();
            URL url2 = new URI("https://docs.oracle.com/javase/8/docs/api/overview-summary.html").toURL();
            WebPage webPage1 = new WebPage(url1, "test", "test, test1, test2");
            Main.addPageToIndex(webPage1);

            Main.removeFromIndexByURL(url2);

            assertAll(
                    () -> assertEquals(3, Main.getIndexMap().size()),
                    () -> assertEquals(1, Main.getPagesByKeyWord("test").size()),
                    () -> assertEquals(1, Main.getPagesByKeyWord("test1").size()),
                    () -> assertEquals(1, Main.getPagesByKeyWord("test2").size())
            );
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }

    @Test
    @DisplayName("Testing remove page with null arguments")
    void engineTest_removePageWithNullArguments() {
        assertThrows(NullPointerException.class, () -> Main.removeFromIndexByURL(null));
    }
}
