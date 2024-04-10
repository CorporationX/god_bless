package faang.school.godbless.url_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, List<WebPage>> index = new HashMap<>();

    private static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\s+");

        for (String word : words) {
            if (!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
            }
            index.get(word).add(webPage);
        }
    }

    private static List<WebPage> searchWebPages(String keyword) {
        if (index.containsKey(keyword)) {
            return index.get(keyword);
        } else {
            System.out.println("Веб-страницы с ключевым словом '" + keyword + "' не найдены");
            return null;
        }
    }

    private static void removeWebPage(String url) {
        for (List<WebPage> webPages : index.values()) {
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
        System.out.println(url + " удалён");
    }

    public static void main(String[] args) {
        WebPage page1 = new WebPage("url1", "Title 1", "Содержание WebPage1, ключ спасибо");
        WebPage page2 = new WebPage("url2", "Title 2", "Содержание WebPage2, ключ пожалуйста");
        WebPage page3 = new WebPage("url3", "Title 3", "Содержание WebPage3, ключ пожалуйста");
        indexWebPage(page1);
        indexWebPage(page2);
        indexWebPage(page3);
        System.out.println("WebPages с ключевым словом \"пожалуйста\": ");
        List<WebPage> searchResult = searchWebPages("пожалуйста");
        for (WebPage page : searchResult) {
            System.out.println("Title: " + page.getTitle() + ", URL: " + page.getUrl());
        }
        removeWebPage("url2");
        System.out.println("WebPages с ключевым словом \"пожалуйста\": ");
        for (WebPage page : searchResult) {
            System.out.println("Title: " + page.getTitle() + ", URL: " + page.getUrl());
        }
    }
}
