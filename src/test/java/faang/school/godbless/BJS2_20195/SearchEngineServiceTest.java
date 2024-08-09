package faang.school.godbless.BJS2_20195;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SearchEngineServiceTest {

    private SearchEngineService searchEngineService;
    private WebPage page1;
    private WebPage page2;

    @BeforeEach
    void setUp() {
        this.page1 = new WebPage("https://faang-school.com", "Google HashMap", "HashMap TreeMap LinkedHashMap");
        this.page2 = new WebPage("www.habrLinkedHashMap.com", "LinkedHashMap", "Map LinkedHashMap");
        Map<String, Set<WebPage>> index = new HashMap<>(Map.of(
                "Google", new HashSet<>(Set.of(page1)),
                "HashMap", new HashSet<>(Set.of(page1)),
                "TreeMap", new HashSet<>(Set.of(page1)),
                "LinkedHashMap", new HashSet<>(Set.of(page1, page2)),
                "Map", new HashSet<>(Set.of(page2))
        ));
        searchEngineService = new SearchEngineService(index);
    }

    @Test
    void indexWebPage() {
        WebPage newPage = new WebPage("https://www.youtube.com", "Google", "Vlad HashMap LinkedHashMap");
        Map<String, Set<WebPage>> correctAnswer = Map.of(
                "Google", Set.of(page1, newPage),
                "HashMap", Set.of(page1, newPage),
                "TreeMap", Set.of(page1),
                "LinkedHashMap", Set.of(page1, page2, newPage),
                "Vlad", Set.of(newPage),
                "Map", Set.of(page2)
        );

        searchEngineService.indexWebPage(newPage);
        Map<String, Set<WebPage>> result = searchEngineService.getIndex();

        assertEquals(correctAnswer, result);
    }

    @Test
    void getWebPages() {
        Set<WebPage> correctAnswer = Set.of(page1, page2);

        Set<WebPage> result = searchEngineService.getWebPages("LinkedHashMap");

        assertEquals(correctAnswer, result);
    }

    @Test
    void removeWebPage() {
        Map<String, Set<WebPage>> correctAnswer = Map.of(
                "Google", Set.of(page1),
                "HashMap", Set.of(page1),
                "TreeMap", Set.of(page1),
                "LinkedHashMap", Set.of(page1)
        );

        searchEngineService.removeWebPage("www.habrLinkedHashMap.com");
        Map<String, Set<WebPage>> result = searchEngineService.getIndex();

        assertEquals(correctAnswer, result);
    }
}