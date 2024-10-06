package GoogleEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<String, List<WebPage>> PAGES_MAP = new HashMap<>();

    public static void main(String[] args) {

        WebPage page1 = new WebPage("http://example.com/1",
                "Example 1", "First example of some content!");
        WebPage page2 = new WebPage("http://example.com/2",
                "Example 2", "Second example of some content!");

        addPage(page1);
        addPage(page2);

        List<WebPage> searchResult = findByWord("example");
        System.out.println("Found pages with a word \"example\"");
        for (WebPage webPage : searchResult) {
            System.out.println(webPage.getTitle() + " - " + webPage.getUrl());
        }
        System.out.println();

        removeByUrl("http://example.com/1");
        printPages();
    }

    public static void addPage (WebPage page) {
        String[] words = page.getContent().split("[^\\p{L}\\p{Nd}]+");
        for (String word : words) {
            PAGES_MAP.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> findByWord (String word) {
        return PAGES_MAP.get(word);
    }

    public static void removeByUrl (String url) {
        PAGES_MAP.forEach((k, v) -> {
            v.removeIf(w -> w.getUrl().equals(url));
        });
        PAGES_MAP.values().removeIf(List::isEmpty);
    }

    public static void printPages () {
        PAGES_MAP.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
