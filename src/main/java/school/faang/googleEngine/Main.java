package school.faang.googleEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final  Map<String, List<WebPage>> URL = new HashMap<>();

    public static void main(String[] args) {


        WebPage googleWebPage  = new WebPage("https://www.google.com", "Google", "Google is the best search platform in the world");
        WebPage bingWebPage = new WebPage("https://www.bing.com", "Bing", "Bing is the best");
        WebPage yahooWebPage = new WebPage("https://www.yahoo.com", "Yahoo", "Yahoo is search engine");

        indexWebPage(googleWebPage );
        indexWebPage(bingWebPage);
        indexWebPage(yahooWebPage);

        searchByWord("google").forEach(System.out::println);

    }

    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split("'\\S+'");
        for (String word : words) {
            URL.putIfAbsent(word, new ArrayList<>());
            if (!URL.get(word).contains(webPage)) {
                URL.get(word).add(webPage);
            }
        }
    }
    public static List<WebPage> searchByWord(String keyword) {
        return URL.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    public static void remove(String url) {
        for (List<WebPage> pages : URL.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}
