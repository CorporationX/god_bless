package faang.school.godbless.javahashmap.searchengine;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SearchEngineTest {

    private static final String THIS = "this";
    private static final String IS = "is";
    private static final String CONTENT = "content";
    private static final String HELLO = "hello";
    private static final String WORLD = "world";
    private static final String MINE = "mine";
    private static final String EXAMPLE = "example";
    private static final WebPage WEB_PAGE_1 = new WebPage("https://ya.ru", "Some title yandex", "This is content");
    private static final WebPage WEB_PAGE_2 = new WebPage("https://google.com", "Some title google", "Hello world is mine!");
    private static final WebPage WEB_PAGE_3 = new WebPage("https://mail.ru", "Some title mail", "Hello, example");

    @Test
    void testIndexWebPage() {
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.indexWebPage(WEB_PAGE_1);
        searchEngine.indexWebPage(WEB_PAGE_2);
        searchEngine.indexWebPage(WEB_PAGE_3);

        Map<String, List<WebPage>> keywordToWebPagesMap = searchEngine.getKeywordToWebPagesMap();

        assertEquals(7 , keywordToWebPagesMap.size());
        assertTrue(keywordToWebPagesMap.containsKey(THIS));
        assertTrue(keywordToWebPagesMap.containsKey(IS));
        assertTrue(keywordToWebPagesMap.containsKey(CONTENT));
        assertTrue(keywordToWebPagesMap.containsKey(HELLO));
        assertTrue(keywordToWebPagesMap.containsKey(WORLD));
        assertTrue(keywordToWebPagesMap.containsKey(MINE));
        assertTrue(keywordToWebPagesMap.containsKey(EXAMPLE));

        List<WebPage> webPagesWithKeyThis = keywordToWebPagesMap.get(THIS);
        assertEquals(1, webPagesWithKeyThis.size());
        assertTrue(webPagesWithKeyThis.contains(WEB_PAGE_1));

        List<WebPage> webPagesWithKeyIs = keywordToWebPagesMap.get(IS);
        assertEquals(2, webPagesWithKeyIs.size());
        assertTrue(webPagesWithKeyIs.contains(WEB_PAGE_1));
        assertTrue(webPagesWithKeyIs.contains(WEB_PAGE_2));

        List<WebPage> webPagesWithKeyContent = keywordToWebPagesMap.get(CONTENT);
        assertEquals(1, webPagesWithKeyContent.size());
        assertTrue(webPagesWithKeyIs.contains(WEB_PAGE_1));

        List<WebPage> webPagesWithKeyHello = keywordToWebPagesMap.get(HELLO);
        assertEquals(2, webPagesWithKeyHello.size());
        assertTrue(webPagesWithKeyHello.contains(WEB_PAGE_2));
        assertTrue(webPagesWithKeyHello.contains(WEB_PAGE_3));

        List<WebPage> webPagesWithKeyWorld = keywordToWebPagesMap.get(WORLD);
        assertEquals(1, webPagesWithKeyWorld.size());
        assertTrue(webPagesWithKeyIs.contains(WEB_PAGE_2));

        List<WebPage> webPagesWithKeyMine = keywordToWebPagesMap.get(MINE);
        assertEquals(1, webPagesWithKeyMine.size());
        assertTrue(webPagesWithKeyMine.contains(WEB_PAGE_2));

        List<WebPage> webPagesWithKeyExample = keywordToWebPagesMap.get(EXAMPLE);
        assertEquals(1, webPagesWithKeyExample.size());
        assertTrue(webPagesWithKeyExample.contains(WEB_PAGE_3));
    }

    @Test
    void testSearchWebPages() {
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.indexWebPage(WEB_PAGE_1);
        searchEngine.indexWebPage(WEB_PAGE_2);
        searchEngine.indexWebPage(WEB_PAGE_3);

        List<WebPage> searchResult = searchEngine.searchWebPages(HELLO);

        assertEquals(2, searchResult.size());
        assertTrue(searchResult.contains(WEB_PAGE_2));
        assertTrue(searchResult.contains(WEB_PAGE_3));

        searchResult = searchEngine.searchWebPages(WORLD);

        assertEquals(1, searchResult.size());
        assertTrue(searchResult.contains(WEB_PAGE_2));

        searchResult = searchEngine.searchWebPages("Nothing");

        assertEquals(0, searchResult.size());
    }

    @Test
    void testRemoveWebPage() {
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.indexWebPage(WEB_PAGE_1);
        searchEngine.indexWebPage(WEB_PAGE_2);
        searchEngine.indexWebPage(WEB_PAGE_3);

        searchEngine.removeWebPage(WEB_PAGE_2.getUrl());

        Map<String, List<WebPage>> keywordToWebPagesMap = searchEngine.getKeywordToWebPagesMap();

        assertEquals(5, keywordToWebPagesMap.size());
        assertTrue(keywordToWebPagesMap.containsKey(THIS));
        assertTrue(keywordToWebPagesMap.containsKey(IS));
        assertTrue(keywordToWebPagesMap.containsKey(CONTENT));
        assertTrue(keywordToWebPagesMap.containsKey(HELLO));
        assertTrue(keywordToWebPagesMap.containsKey(EXAMPLE));

        List<WebPage> webPagesWithKeyThis = keywordToWebPagesMap.get(THIS);
        assertEquals(1, webPagesWithKeyThis.size());
        assertTrue(webPagesWithKeyThis.contains(WEB_PAGE_1));

        List<WebPage> webPagesWithKeyIs = keywordToWebPagesMap.get(IS);
        assertEquals(1, webPagesWithKeyIs.size());
        assertTrue(webPagesWithKeyIs.contains(WEB_PAGE_1));

        List<WebPage> webPagesWithKeyContent = keywordToWebPagesMap.get(CONTENT);
        assertEquals(1, webPagesWithKeyContent.size());
        assertTrue(webPagesWithKeyIs.contains(WEB_PAGE_1));

        List<WebPage> webPagesWithKeyHello = keywordToWebPagesMap.get(HELLO);
        assertEquals(1, webPagesWithKeyHello.size());
        assertTrue(webPagesWithKeyHello.contains(WEB_PAGE_3));

        List<WebPage> webPagesWithKeyExample = keywordToWebPagesMap.get(EXAMPLE);
        assertEquals(1, webPagesWithKeyExample.size());
        assertTrue(webPagesWithKeyExample.contains(WEB_PAGE_3));
    }
}