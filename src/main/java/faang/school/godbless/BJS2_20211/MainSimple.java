package faang.school.godbless.BJS2_20211;

import java.util.*;

public class MainSimple {
    private static Map<String, List<WebPage>> mapIndex = new HashMap<>();
    private static Set<WebPage> setIndex = new HashSet<>();
//    private static Map<String, NodeWebPageMain2> nodeIndex = new HashMap<>();

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
        System.out.println("+++++++++++++++++");
        Optional<List<WebPage>> webPages = Optional.ofNullable(searchByWord("hello"));
        if (webPages.isPresent()) {
            for (var webPage : webPages.get()) {
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
            String[] contentByWords = webPage.getContent().split(" ");
            for (String word : contentByWords) {
                if (!mapIndex.containsKey(word)) {
                    mapIndex.put(word, new ArrayList<>() {{
                        add(webPage);
                    }});
                } else {
                    mapIndex.get(word).add(webPage);
                }
            }
        }
    }

    private static List<WebPage> searchByWord(String word) {
        return mapIndex.get(word);
    }

    private static void removeByUrl (String url) {
        for (var entry : mapIndex.entrySet()) {
            Iterator<WebPage> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                WebPage webPage = iterator.next();
                if (webPage.getUrl().equals(url)) {
                    iterator.remove();
                }
            }
        }
    }
}
