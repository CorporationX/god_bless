package school.faang.search.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SearchEngine {
    private final Map<String, List<WebPage>> wordToPages = new HashMap<>();
    private final Map<String, Map<String, Integer>> urlToPositions = new HashMap<>();

    public void add(WebPage page) {
        Objects.requireNonNull(page, "page is null");
        String[] wordsArr = page.getContent().split("\\PL+");
        Set<String> words = new HashSet<>(Arrays.asList(wordsArr));
        Map<String, Integer> urlToIndex = new HashMap<>();

        for (String word : words) {
            List<WebPage> pages = wordToPages.getOrDefault(word, new ArrayList<>());
            pages.add(page);
            wordToPages.put(word, pages);
            urlToIndex.put(word, pages.size() - 1);
        }
        urlToPositions.put(page.getUrl(), urlToIndex);
    }

    public List<WebPage> getPages(String word) {
        return wordToPages.get(word);
    }

    public void remove(String url) {
        Map<String, Integer> wordToPosition = urlToPositions.get(url);
        for (Map.Entry<String, Integer> entry : wordToPosition.entrySet()) {
            String word = entry.getKey();
            int index = entry.getValue();

            List<WebPage> pages = wordToPages.get(word);
            pages.set(index, pages.get(pages.size() - 1));
            WebPage last = pages.remove(pages.size() - 1);
            if (pages.isEmpty()) {
                wordToPages.remove(word);
            } else {
                wordToPages.put(word, pages);
            }
            Map<String, Integer> map = urlToPositions.get(last.getUrl());
            map.put(word, index);
        }
        urlToPositions.remove(url);
    }
}
