package school.faang.forthTask;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class SearchEngine {
    // According to the conditions we need to use List,
    // but better to use Set to escape duplicates for the index words
    final private Map<String, List<WebPage>> index = new HashMap<>();

    /**
     * Indexing a webPage
     * @param page - WebPage entity to be indexed
     */
    public void indexWebPage(WebPage page) {
        String[] words = page.getContent().split("\\W+");
        for (String word : words) {
            word = word.toLowerCase();
            index.computeIfAbsent(word, key -> new ArrayList<>()).add(page);
        }
    }

    /**
     * Search by a keyword
     * @param keyword
     * @return
     */
    public List<WebPage> search(String keyword) {
        return index.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    /**
     * Remove webPage from index map by an url
     * @param url
     */
    public void removeWebPage(String url) {
        for (List<WebPage> pages : index.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}
