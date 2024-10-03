package googles_mini_search_engine;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @Getter
    private static final Map<String, List<WebPage>> webPages = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://www.google.com", "Google", "Search engine");
        WebPage webPage2 = new WebPage("https://www.yahoo.com", "Yahoo", "Technical search engine");
        WebPage webPage3 = new WebPage("https://www.bing.com", "Bing", "Test search domain");
        indexPage(webPage1);
        indexPage(webPage2);
        indexPage(webPage3);
        System.out.println(search("engine"));
        removePage(webPage1);
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
        for (String word : webPage.getContent().toLowerCase().split(" ")) {
            webPages.get(word).remove(webPage);
        }
    }
}
