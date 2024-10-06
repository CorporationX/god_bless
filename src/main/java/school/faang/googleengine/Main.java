package school.faang.googleengine;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    static Map<String, List<WebPage>> webPageMap = new ConcurrentHashMap<>();

    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\s+");
        for (String st : words) {
            webPageMap.computeIfAbsent(st.toLowerCase(), wp -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findByWord(String word) {
        return webPageMap.getOrDefault(word.toLowerCase(), new ArrayList<>());
    }

    public static Boolean removeByUrl(String url) {
        boolean removed = false;
        for (Map.Entry<String, List<WebPage>> entry : webPageMap.entrySet()) {
            boolean wasRemoved = entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
            if (wasRemoved) {
                removed = true;
            }
            if (entry.getValue().isEmpty()) {
                webPageMap.remove(entry.getKey());
            }

        }
        return removed;
    }

    public static void main(String[] args) {
        // Create sample WebPage objects
        WebPage page1 = new WebPage("http://example.com/page1", "first page", "This is the first test content");
        WebPage page2 = new WebPage("http://example.com/page2", "second page", "This is the second test content");
        WebPage page3 = new WebPage("http://example.com/page3", "third page", "More content for testing purposes");

        // Add WebPages to the map

        indexWebPage(page1);
        indexWebPage(page2);
        indexWebPage(page3);

        // Find WebPages by word
        System.out.println("Pages with word 'test': " + findByWord("test"));
        System.out.println("Pages with word 'first': " + findByWord("first"));

        // Remove a WebPage by URL
        boolean removedPage1 = removeByUrl("http://example.com/page1");
        System.out.println("Removed page1: " + removedPage1);

        // Verify removal
        System.out.println("Pages with word 'first' after removal: " + findByWord("first"));

        // Test removing a non-existent URL
        boolean removedNonExistent = removeByUrl("http://example.com/nonexistent");
        System.out.println("Removed nonexistent page: " + removedNonExistent);

        // Final check of the map content
        System.out.println("Final map content: " + webPageMap);
    }
}