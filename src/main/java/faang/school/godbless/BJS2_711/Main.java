package faang.school.godbless.BJS2_711;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, List<WebPage>> index = new HashMap<>();

    public static void main(String[] args) {
        // Creating some sample WebPages
        WebPage page1 = new WebPage("https://example.com/page1", "FAANG", "This is a sample page.");
        WebPage page2 = new WebPage("https://example.com/page2", "BOOTCAMP", "Another example page.");
        WebPage page3 = new WebPage("https://example.com/page3", "AMAZON", "Yet another example.");

        // Adding WebPages to the index
        addToIndexByKeyWord(page1);
        addToIndexByKeyWord(page2);
        addToIndexByKeyWord(page3);

        // Listing WebPages for a keyword
        String keyword = "example";
        List<WebPage> pagesForWord = listWebPage(keyword);
        System.out.println("Pages for word '" + keyword + "':");
        for (WebPage page : pagesForWord) {
            System.out.println("Page URL: " + page.getUrl());
        }

        // Removing a WebPage by URL
        String urlToRemove = "https://example.com/page1";
        remove(urlToRemove);

        // Listing WebPages for the same keyword after removal
        pagesForWord = listWebPage(keyword);
        System.out.println("\nPages for word '" + keyword + "' after removal:");
        for (WebPage page : pagesForWord) {
            System.out.println("Page URL: " + page.getUrl());
        }
    }

    public static void addToIndexByKeyWord(WebPage webPage) {
        String[] words = webPage.getContent().split("[^a-zA-Z']+");
        for (String word : words) {
            index.computeIfAbsent(word, key -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> listWebPage(String keyWord) {
        return index.get(keyWord);
    }

    public static void remove(String url) {
        index.values().forEach(pages -> pages.removeIf(page -> page.getUrl().equals(url)));
    }
}