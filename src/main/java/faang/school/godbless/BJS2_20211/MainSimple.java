package faang.school.godbless.BJS2_20211;

import java.util.*;

public class MainSimple {
    private static Map<String, List<WebPage>> mapIndex = new HashMap<>();
    private static Set<WebPage> setIndex = new HashSet<>();

    public static void main(String[] args) {
        List<WebPage> pages = List.of(new WebPage("https://ya.ru", "Yandex", "yandex java hello"),
                new WebPage("https://google.com", "Google", "google java"),
                new WebPage("https://netflix.com", "Netflix", "netflix hello something else"),
                new WebPage("https://amazon.com", "Amazon", "else amazing hello something")
        );

        for (WebPage page : pages) {
            indexWebPage(page);
        }
        for (var entry : mapIndex.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            for (var webPage : entry.getValue()) {
                System.out.println(webPage.getUrl());
            }
            System.out.println("-------------------------");
        }
        System.out.println("Search by word");
        List<WebPage> webPages = searchByWord("hello");
        if (webPages != null) {
            for (var webPage : webPages) {
                System.out.println(webPage.getUrl());
            }
        } else {
            System.out.println("Can't find web pages with this word");
        }
        removeByUrl("https://ya.ru");
        System.out.println("After remove");
        for (var entry : mapIndex.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            for (var webPage : entry.getValue()) {
                System.out.println(webPage.getUrl());
            }
            System.out.println("-------------------------");
        }
    }

    private static void indexWebPage(WebPage webPage) {
        if (!setIndex.contains(webPage)) {
            setIndex.add(webPage);
            String[] contentByWords = webPage.getContent().split(" ");
            for (String word : contentByWords) {
                mapIndex.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
                mapIndex.get(word).add(webPage);
            }
        }
    }

    private static List<WebPage> searchByWord(String word) {
        return mapIndex.get(word);
    }

    private static void removeByUrl(String url) {
        for (var entry : mapIndex.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
