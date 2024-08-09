package faang.school.godbless.BJS2_20211;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main2 {
    private static Map<String, List<NodeWebPage>> mapIndex = new HashMap<>();
    private static Set<WebPage> setIndex = new HashSet<>();
    private static Map<String, List<NodeWebPage>> listNodesQuickRemove = new HashMap<>();

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
            System.out.println("key: " + entry.getKey());
            for (var webPage : entry.getValue()) {
                System.out.println(webPage.getWebPage().getUrl());
            }
            System.out.println("=======================");
        }
    }

    public static void indexWebPage(WebPage webPage) {
        NodeWebPage nodeToIndex = new NodeWebPage(webPage);
        if (!setIndex.contains(webPage)) {
            String[] contentByWords = webPage.getContent().split(" ");
            for (String word : contentByWords) {
                if (!mapIndex.containsKey(word)) {
                    mapIndex.put(word, new LinkedList<>(Arrays.asList(nodeToIndex)));
                } else {
                    mapIndex.get(word).add(nodeToIndex);
                }
            }
        }
        if (!listNodesQuickRemove.containsKey(webPage.getUrl())) {
            listNodesQuickRemove.put(webPage.getUrl(), new LinkedList<>());
        }
    }
}
