package faang.school.godbless.SearchPageByIndexes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
public class MainTest {
     private Main main;
    private WebPage page1;
    private WebPage page2;

    @BeforeEach
    public void setUp() {
        main = new Main();
        page1 = new WebPage("http://example.com", "Example Title", "This is example content");
        page2 = new WebPage("http://test.com", "Test Title", "Test content with keywords");
    }

    @Test
    public void testRegistrationPageIndexes() {
        main.registrationPageIndexes(page1);
        assertTrue(main.getPagesKeyIndexes().containsKey("This"));
        assertTrue(main.getPagesKeyIndexes().get("This").contains(page1));
        assertTrue(main.getPagesKeyIndexes().containsKey("example"));
        assertTrue(main.getPagesKeyIndexes().get("example").contains(page1));
    }

    @Test
    public void testSearchPagesByKeyWord() {
        main.registrationPageIndexes(page1);
        Set<WebPage> result = main.searchPagesByKeyWord("example");
        assertEquals(1, result.size());
        assertTrue(result.contains(page1));

        Set<WebPage> noResult = main.searchPagesByKeyWord("nonexistent");
        assertTrue(noResult.isEmpty());
    }

    @Test
    public void testDeletePageFromKeyIndexes() {
        main.registrationPageIndexes(page1);
        main.registrationPageIndexes(page2);

        main.deletePageFromKeyIndexes("http://example.com");

        assertFalse(main.getAllPagesURL().containsKey("http://example.com"));
        assertFalse(main.getPagesKeyIndexes().get("This").contains(page1));
        assertTrue(main.getPagesKeyIndexes().get("keywords").contains(page2));
    }

    @Test
    public void testFindByURL() {
        main.createURLForPage(page1);
        Optional<WebPage> foundPage = main.findByURL("http://example.com");
        assertTrue(foundPage.isPresent());
        assertEquals(page1, foundPage.get());

        Optional<WebPage> notFoundPage = main.findByURL("http://nonexistent.com");
        assertFalse(notFoundPage.isPresent());
    }

    @Test
    public void testCreateURLForPage() {
        main.createURLForPage(page1);
        assertTrue(main.getAllPagesURL().containsKey("http://example.com"));
        assertEquals(page1, main.getAllPagesURL().get("http://example.com"));
    }

    @Test
    public void testDeletePageByURL() {
        main.createURLForPage(page1);
        main.deletePageByURL("http://example.com");
        assertFalse(main.getAllPagesURL().containsKey("http://example.com"));
    }

    @Test
    public void testCleanKeyWord() {
        String result = main.cleanKeyWord("example,.");
        assertEquals("example", result);
    }
}
