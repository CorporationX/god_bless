package school.faang.BJS2_32929;

import java.util.*;

public class SearchEngine {
    private Map<String, List<WebPage>> index = new HashMap<>();

    public void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split("\\W+");
        for (String word : words) {
            index.putIfAbsent(word, new ArrayList<>());
            index.get(word).add(webPage);
        }
    }

    public List<WebPage> search(String keyword) {
        return index.getOrDefault(keyword.toLowerCase(), Collections.emptyList());
    }

    public void removeWebPage(String url) {
        for (List<WebPage> webPages : index.values()) {
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
