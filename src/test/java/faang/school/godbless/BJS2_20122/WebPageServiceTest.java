package faang.school.godbless.BJS2_20122;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WebPageServiceTest {
    private WebPageService webPageService;

    @BeforeEach
    void setUp() {
        webPageService = new WebPageService(new HashMap<>());
        webPageService.addPage(new WebPage("opensource.com", "best projects", "This is some projects for free!"));
        webPageService.addPage(new WebPage("test.com", "some title", "some content"));
    }

    @Test
    void testAddingNewPage(){
        WebPage page = new WebPage("google.com", "News", "Some news from Moscow: People singing in the square");
        webPageService.addPage(page);
        List<WebPage> pages = webPageService.getPages().get("news");
        assertEquals(List.of(page), pages);
    }

    @Test
    void testGetPages(){
        webPageService.addPage(new WebPage("somesite.com", "some title", "some content"));
        List<WebPage> pages = webPageService.getPagesByWord("some");
        assertEquals(3, pages.size());
    }

    @Test
    void testRemovePageByUrl(){
        webPageService.removePage("test.com");
        assertEquals(1, webPageService.getPagesByWord("some").size());
    }

    @Test
    void testAddingAddedPage(){
        assertThrows(IllegalArgumentException.class, () -> webPageService.addPage(new WebPage("test.com", "some title", "some content")));
    }
}
