import org.example.model.WebPage;
import org.example.service.MiniGoogleSearchService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MiniGoogleSearchServiceTest {
    @Test
    @DisplayName("test to check indexing new webpage")
    void testToCheckIndexingNewWebPage() {
        WebPage newWebPage = new WebPage("http://ai.com", "AI in football", "some content about AI in football");

        MiniGoogleSearchService.indexingWebPage(newWebPage);

        assertEquals(2, MiniGoogleSearchService.webPagesByKeyWord.get("in").size());
        assertEquals(1, MiniGoogleSearchService.webPagesByKeyWord.get("football").size());
        assertNull(MiniGoogleSearchService.webPagesByKeyWord.get("unKnownPage"));
    }

    @Test
    @DisplayName("test search by key word")
    void testSearchByKeyWord() {
        int sizeOfResult = MiniGoogleSearchService.searchWebPageByKeyWord("sport").size();

        assertEquals(1, sizeOfResult);
    }

    @Test
    @DisplayName("test to remove webpage with url")
    void testToRemoveWebPageByUrl() {
        int sizeOfSAIContentPages = MiniGoogleSearchService.searchWebPageByKeyWord("ai").size();

        MiniGoogleSearchService.removeWebPageByUrl("http://sport.kz");

        assertEquals(0, MiniGoogleSearchService.webPagesByKeyWord.get("sport").size());
        assertEquals(sizeOfSAIContentPages, MiniGoogleSearchService.webPagesByKeyWord.get("ai").size());
        assertThrows(NullPointerException.class, () -> MiniGoogleSearchService.removeWebPageByUrl("new.kz"));
    }
}
