package school.faang.searchengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.searchengine.Main.findWebPageByKeyWord;
import static school.faang.searchengine.Main.indexWebPage;
import static school.faang.searchengine.Main.webPagesOfKeyWords;
import static school.faang.searchengine.Main.keyWordsPerUrl;
import static school.faang.searchengine.Main.removePageByUrl;

public class WebPageTest {
    private static WebPage page1;
    private static WebPage page2;
    private static WebPage page3;

    @BeforeEach
    public void testDataSetUp() {
        webPagesOfKeyWords = new HashMap<>();
        keyWordsPerUrl = new HashMap<>();
        page1 = new WebPage("https://test-page1.com", "Title1", "This is an test-page1 content.");
        page2 = new WebPage("https://test-page2.com", "Title2", "This is another page content. Some new words here. Page again.");
        page3 = new WebPage("https://test-page3.com", "Title3", "This is a new PAGE with New Content. Very interesting info.");
        indexWebPage(page1);
        indexWebPage(page2);
        indexWebPage(page3);
    }

    @Test
    public void testIndexWebPage() {
        assertEquals(17, webPagesOfKeyWords.size());

        // Single element in a list
        assertEquals(1, webPagesOfKeyWords.get("info").size());
        assertTrue(webPagesOfKeyWords.get("info").contains(page3));

//        Multiple elements in the list
        assertEquals(3, webPagesOfKeyWords.get("is").size());
        assertTrue(webPagesOfKeyWords.get("is").containsAll(List.of(page1, page2, page3)));
    }

    @Test
    public void testFindWebPageByKeyWord() {
        assertEquals(List.of(page3), findWebPageByKeyWord("interesting"));
        assertEquals(List.of(page2, page3), findWebPageByKeyWord("new"));
        assertNull(findWebPageByKeyWord("NotFound"));
    }

    @Test
    public void testRemovePageByUrl() {
        removePageByUrl("https://test-page3.com");
        assertEquals(12, webPagesOfKeyWords.size());
        for (String key : webPagesOfKeyWords.keySet()) {
            assertFalse(webPagesOfKeyWords.get(key).contains(page3));
        }
    }
}
