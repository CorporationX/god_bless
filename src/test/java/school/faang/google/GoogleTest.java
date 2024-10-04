package school.faang.google;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoogleTest {

    private Google google;

    private WebPage webPage1;
    private WebPage webPage2;
    private WebPage webPage3;

    @BeforeEach
    public void setUp() {
        webPage1 = new WebPage("https://one.com", "Title 1", "one two three");
        webPage2 = new WebPage("https://two.com", "Title 2", "one four five");
        webPage3 = new WebPage("https://three.com", "Title 3", "two six seven");

        google = new Google();

        google.indexWebPage(webPage1);
        google.indexWebPage(webPage2);
        google.indexWebPage(webPage3);
    }

    @Test
    void addAndFindByRequestTest() {
        google.indexWebPage(new WebPage("https://four.com", "Title 4", "one two eleven"));
        List<WebPage> responses = google.search("two");
        assertEquals(3, responses.size());
    }

    @Test
    void deletePageTest() {
        google.removeWebPage("https://two.com");
        List<WebPage> responses = google.search("two");
        assertEquals(2, responses.size());
    }

    @Test
    void notAddIfAlreadyExistTest() {
        google.indexWebPage(new WebPage("https://one.com", "Title 1", "one two three"));
        List<WebPage> responses = google.search("two");
        assertEquals(2, responses.size());
    }
}
