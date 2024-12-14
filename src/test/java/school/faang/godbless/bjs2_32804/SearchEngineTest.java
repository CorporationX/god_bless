package school.faang.godbless.bjs2_32804;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchEngineTest {
    private SearchEngine searchEngine;

    @BeforeEach
    public void init() {
        searchEngine = new SearchEngine();
        searchEngine.addToIndex(new WebPage("url1", "title1", "rice meat tasty"));
        searchEngine.addToIndex(new WebPage("url2", "title2", "meat good cook"));
        searchEngine.addToIndex(new WebPage("url3", "title3", "rare books"));
    }

    @Test
    void testAddToIndex() {
        WebPage newPage = new WebPage("url4", "title4", "The news sport how?");
        searchEngine.addToIndex(newPage);

        Optional<List<WebPage>> optionalPages = searchEngine.findPages("news");
        assertTrue(optionalPages.isPresent());
        assertEquals(newPage, optionalPages.get().get(0));

        optionalPages = searchEngine.findPages("how?");
        assertTrue(optionalPages.isEmpty());

        optionalPages = searchEngine.findPages("how");
        assertTrue(optionalPages.isPresent());
        assertEquals(newPage, optionalPages.get().get(0));

        optionalPages = searchEngine.findPages("The");
        assertTrue(optionalPages.isEmpty());
    }

    @Test
    void testRemovePage() {
        searchEngine.removeByUrl("url3");

        Optional<List<WebPage>> optionalPages = searchEngine.findPages("books");
        assertTrue(optionalPages.isPresent());
        assertEquals(0, optionalPages.get().size());
    }
}