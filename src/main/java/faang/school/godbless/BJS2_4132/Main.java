package faang.school.godbless.BJS2_4132;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> SEARCH_INDEX = new HashMap<>();

    public static void main(String[] args) {
        indexWebPage(new WebPage("https://example.com", "Заголовок 1", "Описание очень большой и содержательной страницы. Ну, или не очень."));
        indexWebPage(new WebPage("https://example.ru", "Заголовок 2", "Описание очень маленькой, но содержательной страницы."));
        indexWebPage(new WebPage("https://example.us", "Заголовок 3", "Описание"));

        for (WebPage searchedPage : searchWebPages("содержательной")) {
            System.out.println(searchedPage.getTitle() + " - " + searchedPage.getUrl());
        }

        System.out.println("===========================================================");

        for (WebPage searchedPage : searchWebPages("маленькой")) {
            System.out.println(searchedPage.getTitle() + " - " + searchedPage.getUrl());
        }

        System.out.println("===========================================================");

        removeWebPage("https://example.com");

        for (WebPage searchedPage : searchWebPages("Описание")) {
            System.out.println(searchedPage.getTitle() + " - " + searchedPage.getUrl());
        }
    }

    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("[\\s,.!]+");
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            SEARCH_INDEX.computeIfAbsent(lowerCaseWord, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> searchWebPages(String keyword) {
        return SEARCH_INDEX.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    public static void removeWebPage(String url) {
        for (List<WebPage> pages : SEARCH_INDEX.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}