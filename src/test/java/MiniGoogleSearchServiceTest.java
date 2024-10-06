import model.WebPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.MiniGoogleSearchService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniGoogleSearchServiceTest {
    @Test
    @DisplayName("test to check indexing new webpage")
    void testToCheckIndexingNewWebPage() {
        WebPage newWebPage = new WebPage("http://ai.com", "AI in football", "some content about AI in football");

        MiniGoogleSearchService.indexingWebPage(newWebPage);

        assertEquals(5, MiniGoogleSearchService.webPagesByKeyWord.get("ai").size());
    }

    @Test
    @DisplayName("test search by key word")
    void testSearchByKeyWord() {
        int sizeOfResult = MiniGoogleSearchService.searchWebPageByKeyWord("sport").size();

        assertEquals(5, sizeOfResult);
    }

    @Test
    @DisplayName("test to remove webpage with url")
    void testToRemoveWebPageByUrl() {
        int sizeOfSportContentPages = MiniGoogleSearchService.searchWebPageByKeyWord("sport").size();
        int sizeOfSAIContentPages = MiniGoogleSearchService.searchWebPageByKeyWord("ai").size();

        MiniGoogleSearchService.removeWebPageByUrl("http://sport.kz");
        MiniGoogleSearchService.removeWebPageByUrl("news.kz");

        assertEquals(4, sizeOfSportContentPages - 1);
        assertEquals(3, sizeOfSAIContentPages - 1);
    }
}
