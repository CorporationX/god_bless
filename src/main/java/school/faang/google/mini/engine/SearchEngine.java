package school.faang.google.mini.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    private final Map<String, List<WebPage>> indexMap = new HashMap<>();

    public void indexWebPage(WebPage page) {
        List<String> words = List.of(page.content().split(" "));

        for(String word: words) {
            indexMap.computeIfAbsent(word.toLowerCase(), w -> new ArrayList<>()).add(page);
        }
    }

    public void showSearchIndexContent() {
        for(var pages: indexMap.entrySet()) {
            System.out.println("Word: " + pages.getKey());
            System.out.println("Pages : ");

            for(WebPage page: pages.getValue()) {
                System.out.println(page.url());
            }

            System.out.println("-------------");
            System.out.println();
        }
    }

    public List<WebPage> getWebPages(String word) {
        return indexMap.get(word.toLowerCase()) != null ? indexMap.get(word.toLowerCase()) : new ArrayList<>();
    }

    public void removeWebPageFromIndex(String url) {
        for(Map.Entry<String, List<WebPage>> entry: indexMap.entrySet()) {
            entry.getValue().removeIf(page -> page.url().equals(url));
        }
    }
}
