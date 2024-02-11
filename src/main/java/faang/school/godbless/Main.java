package src.main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, List<WebPage>> map = new HashMap<>();

    static void indexNewWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\s+");
        for (String word : words) {
            List<WebPage> pages = map.getOrDefault(word, new ArrayList<>());
            pages.add(webPage);
            map.put(word, pages);
        }
    }
    public static List<WebPage> search(String keyword) {
        return map.getOrDefault(keyword, new ArrayList<>());
    }
    public static void removePage(String url) {
        for (List<WebPage> pages : map.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }

    public static void main(String[] args) {
        WebPage page = new WebPage("https://google.com/page1", "search", "searchcontent");
        indexNewWebPage(page);
        search("searchcontent");
        removePage("https://google.com/page1");
    }
}
