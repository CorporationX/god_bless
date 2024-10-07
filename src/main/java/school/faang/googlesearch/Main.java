package school.faang.googlesearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webPages = new HashMap();

    public static void main(String[] args) {
        WebPage page1 = new WebPage("https://faang-school.com/", "BootCamp", "This " +
                "is a page of Faang-School Bootcamp");
        WebPage page2 = new WebPage("https://wikipedia.org/", "Wiki", "This is a " +
                "page of Wikipedia");
        WebPage page3 = new WebPage("https://newsuperschool.com/", "BootCamp", "This" +
                " is a page of new super Bootcamp");

        indexWebPage(page1);
        indexWebPage(page2);
        indexWebPage(page3);

        deleteWebPage("https://newsuperschool.com/", webPages);

        for (Map.Entry<String, List<WebPage>> entry : webPages.entrySet()) {
            List<WebPage> pages = entry.getValue();
            for (WebPage page : pages) {
                System.out.println(page.getUrl());
            }
        } // Тест метода deleteWebPage


        System.out.println(searchByKeyword("BootCamp"));

    }

    public static void indexWebPage(WebPage page) {
        String[] words = page.getContent().toLowerCase().split("\\W+");
        for (String word : words) {
            if (!webPages.containsKey(word)) {
                webPages.put(word, new ArrayList<WebPage>());
            }
            webPages.get(word).add(page);
        }
    }

    public static List<WebPage> searchByKeyword(String keyword) {
        return webPages.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    public static void deleteWebPage(String url, Map<String, List<WebPage>> map) {
        for (Map.Entry<String, List<WebPage>> entry : map.entrySet()) {
            List<WebPage> pages = entry.getValue();
            for (int i = 0; i < pages.size(); i++) {
                WebPage page = pages.get(i);
                if (page.getUrl().equals(url)) {
                    pages.remove(page);
                    break;
                }
            }
        }
    }
}
