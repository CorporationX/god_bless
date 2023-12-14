package faang.school.godbless.BJS2_711;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Map<String, List<WebPage>> index = new HashMap<>();

    public static void main(String[] args) {
        WebPage page1 = new WebPage("https://example.com/page1", "FAANG", "This is a page page page page sample page.");
        WebPage page2 = new WebPage("https://example.com/page2", "BOOTCAMP", "Another example page.");
        WebPage page3 = new WebPage("https://example.com/page3", "AMAZON", "Yet another example.");

        addToIndexByKeyWord(page1);
        addToIndexByKeyWord(page2);
        addToIndexByKeyWord(page3);

        index.forEach((a, b) -> {
            System.out.println(a);
            System.out.println(b);
        });

        String keyword = "example";
        List<WebPage> pagesForWord = listWebPage(keyword);
        System.out.println("Pages for word '" + keyword + "':");
        for (WebPage page : pagesForWord) {
            System.out.println("Page URL: " + page.getUrl());
        }

        String urlToRemove = "https://example.com/page1";
        remove(urlToRemove);

        pagesForWord = listWebPage(keyword);
        System.out.println("\nPages for word '" + keyword + "' after removal:");
        for (WebPage page : pagesForWord) {
            System.out.println("Page URL: " + page.getUrl());
        }
    }

    public static void addToIndexByKeyWord(WebPage webPage) {
        Set<String> words = Arrays.stream(webPage.getContent().split("[^a-zA-Z']+")).collect(Collectors.toSet());
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