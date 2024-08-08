package faang.school.godbless.javahashmap.searchengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {

    private final Map<String, List<WebPage>> keywordToWebPagesMap = new HashMap<>();

    public void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split("\\W+");
        for (String word : words) {
            if (!word.isEmpty()) {
                keywordToWebPagesMap.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
            }
        }
    }

    public List<WebPage> searchWebPages(String keyword) {
        return keywordToWebPagesMap.getOrDefault(keyword.toLowerCase(), List.of());
    }

    public void removeWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : keywordToWebPagesMap.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }

        keywordToWebPagesMap.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

    public Map<String, List<WebPage>> getKeywordToWebPagesMap() {
        return keywordToWebPagesMap;
    }
}
