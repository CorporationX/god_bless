package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> index = new HashMap<>();

    public static void main(String[] args) {

        WebPage page1 = new WebPage("https://javarush.com/quests", "Java Rash", "Java is the best programming language");
        WebPage page2 = new WebPage("https://javarush.com/lean", "Python Rash", "Python is the best programming language");
        WebPage page3 = new WebPage("https://javarush.com/teach", "C++ Rash", "C++ is the best programming language");
        addWebPageToIndex(page1);
        addWebPageToIndex(page2);
        addWebPageToIndex(page3);

        List<WebPage> resultPages = searchByKeyword("is");
        for (WebPage page : resultPages) {
            System.out.println(page);
        }
        removePageForUrl("https://javarush.com/lean");
        List<WebPage> resultPages1 = searchByKeyword("is");
        for (WebPage page : resultPages1) {
            System.out.println(page);
        }


    }

    public static void addWebPageToIndex(WebPage page) {
        String[] words = page.getContent().toLowerCase().split(" ");
        for (String word : words) {
            if (!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
            } else {
                List<WebPage> pages = index.get(word);
                pages.add(page);
            }
        }
    }

    public static List<WebPage> searchByKeyword(String keyword) {
        return index.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    public static void removePageForUrl(String url) {
        for (List<WebPage> pages : index.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}



