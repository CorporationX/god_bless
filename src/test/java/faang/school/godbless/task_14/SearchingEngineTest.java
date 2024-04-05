package faang.school.godbless.task_14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchingEngineTest {

    private SearchingEngine engine;
    private WebPage page1, page2, page3;
    @BeforeEach
    void setUp() {
        engine = new SearchingEngine();
        page1 = new WebPage("https://leetcode.com/", "Leetcode", "Hello world");
        page2 = new WebPage("https://www.youtube.com/", "Youtube", "Hello video");
        page3 = new WebPage("https://www.twitch.tv/", "Twitch", "Video streams");
    }

    @Test
    void indexPageGoodPage() {
        assertTrue(engine.indexPage(page1));
    }

    @Test
    void indexPageNullPage() {
        assertFalse(engine.indexPage(null));
    }

    @Test
    void indexPageNonExistingPage() {
        engine.indexPage(page1);
        assertFalse(engine.indexPage(page1));
    }

    @Test
    void findByKeywordGoodWord() {
        engine.indexPage(page1);
        engine.indexPage(page2);
        engine.indexPage(page3);
        List<WebPage> expected = new ArrayList<>();
        expected.add(page2);
        expected.add(page1);
        assertIterableEquals(expected, engine.findByKeyword("Hello"));
    }

    @Test
    void findByKeywordNullWord() {
        engine.indexPage(page1);
        engine.indexPage(page2);
        engine.indexPage(page3);
        assertNull(engine.findByKeyword(null));
    }

    @Test
    void findByKeywordNonExistingWord() {
        engine.indexPage(page1);
        engine.indexPage(page2);
        engine.indexPage(page3);
        assertNull(engine.findByKeyword("bad"));
    }

    @Test
    void removePageByUrlGoodUrl() {
        engine.indexPage(page1);
        engine.indexPage(page2);
        engine.indexPage(page3);
        List<WebPage> expected = new ArrayList<>();
        expected.add(page2);
        assertTrue(engine.removePageByUrl(page1.getUrl()));
        assertIterableEquals(expected, engine.findByKeyword("Hello"));
        assertNull(engine.findByKeyword("world"));
    }

    @Test
    void removePageByUrlNullUrl() {
        engine.indexPage(page1);
        engine.indexPage(page2);
        engine.indexPage(page3);
        assertFalse(engine.removePageByUrl(null));
    }

    @Test
    void removePageByUrlBadUrl() {
        engine.indexPage(page1);
        engine.indexPage(page2);
        engine.indexPage(page3);
        assertFalse(engine.removePageByUrl("bad"));
    }
}