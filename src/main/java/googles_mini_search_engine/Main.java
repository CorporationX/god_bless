package googles_mini_search_engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<String, List<WebPage>> webPages = new HashMap<>();

    public static void main(String[] args) {
        WebPage googlePage = new WebPage("https://www.google.com", "Google", "Search engine");
        WebPage yahooPage = new WebPage("https://www.yahoo.com", "Yahoo", "Technical search engine");
        WebPage bingPage = new WebPage("https://www.bing.com", "Bing", "Test search domain");
        indexPage(googlePage);
        indexPage(yahooPage);
        indexPage(bingPage);
        System.out.println(search("engine"));
        removePage(googlePage);
        System.out.println(webPages);
    }

    public static void indexPage(WebPage webPage) {
        String content = webPage.getContent().toLowerCase();
        for (String word : content.split(" ")) {
            webPages.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> search(String word) {
        return webPages.getOrDefault(word.toLowerCase(), new ArrayList<>());
    }

    public static void removePage(WebPage webPage) {
        String content = webPage.getContent().toLowerCase();
        String[] words = content.split(" ");

        for (String word : words) {
            webPages.computeIfPresent(word, (key, pages) -> {
                pages.remove(webPage);
                return pages.isEmpty() ? null : pages;
            });
        }
    }
}
