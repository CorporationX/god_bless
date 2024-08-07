package faang.school.godbless.googlesearchengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, List<WebPage>> keywordIndex = new HashMap<>();
    private static Map<String, List<String>> urlIndex = new HashMap<>();

    public static void indexWebPage(WebPage page) {
        Set<String> words = new HashSet<>(Arrays.asList(page.getContent().split("\\W+")));
        List<String> keywords = new ArrayList<>();

        for (String word : words) {
            word = word.toLowerCase();
            List<WebPage> list = keywordIndex.computeIfAbsent(word, k -> new LinkedList<>());
            list.add(page);
            keywords.add(word);
        }

        urlIndex.put(page.getUrl(), keywords);
    }

    public static List<WebPage> search(String keyword) {
        return keywordIndex.getOrDefault(keyword.toLowerCase(), Collections.emptyList());
    }

    public static void removeWebPage(String url) {
        List<String> keywords = urlIndex.remove(url);
        if (keywords != null) {
            for (String keyword : keywords) {
                List<WebPage> list = keywordIndex.get(keyword);
                if (list != null) {
                    list.removeIf(page -> page.getUrl().equals(url));
                    if (list.isEmpty()) {
                        keywordIndex.remove(keyword);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WebPage page1 = new WebPage("https://example.com",
                "Example Title",
                "This is an example content. Just an example. And we are done.");
        WebPage page2 = new WebPage("https://another.com",
                "Another Title",
                "This is another example content. Just another example.");

        indexWebPage(page1);
        indexWebPage(page2);

        List<WebPage> results = search("example");
        if (results.isEmpty()) {
            System.out.println("No results found for 'example'.");
        } else {
            System.out.println("Search results for 'example': " + results);
        }

        results = search("nonexistent");
        if (results.isEmpty()) {
            System.out.println("\nNo results found for 'nonexistent'.");
        } else {
            System.out.println("\nSearch results for 'nonexistent': " + results);
        }

        removeWebPage("https://example.com");

        results = search("example");
        if (results.isEmpty()) {
            System.out.println("\nNo results found for 'example' after removal.");
        } else {
            System.out.println("\nSearch results for 'example' after removal: " + results);
        }
    }
}
