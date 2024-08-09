package faang.school.godbless.BJS2_20211.temp;

import faang.school.godbless.BJS2_20211.WebPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main2 {
    private static Map<String, List<NodeWebPageMain2>> mapIndex = new HashMap<>();
    private static Set<WebPage> setIndex = new HashSet<>();
    private static Map<String, List<NodeWebPageMain2>> listNodesQuickRemove = new HashMap<>();

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

        System.out.println("Search by word");
        List<WebPage> webPages = searchByWord("amazing");
        if (!webPages.isEmpty()) {
            webPages.forEach(webPage -> System.out.println(webPage.getUrl()));
        } else {
            System.out.println("Can't find web pages with this word");
        }
    }

    public static void indexWebPage(WebPage webPage) {
        NodeWebPageMain2 nodeToIndex = new NodeWebPageMain2(webPage);

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
            listNodesQuickRemove.put(webPage.getUrl(), new ArrayList<>() {{
                add(nodeToIndex);
            }});
        } else {
            listNodesQuickRemove.get(webPage.getUrl()).add(nodeToIndex);
        }
    }

    private static List<WebPage> searchByWord(String word) {
        List<WebPage> result = new ArrayList<>();
        for (var wordKey : mapIndex.entrySet()) {
            if (wordKey.getKey().equals(word)) {
                for (var nodeWebPage : wordKey.getValue()) {
                    result.add(nodeWebPage.getWebPage());
                }
            }
        }
        return result;
    }

    private static void removeByUrl(String url) {
        List<NodeWebPageMain2> nodesWebPage = listNodesQuickRemove.get(url);
        int index = 0;
        for (NodeWebPageMain2 nodeWebPageMain2 : nodesWebPage) {
            String[] words = nodeWebPageMain2.getWebPage().getContent().split(" ");
            for (var keyWord : mapIndex.entrySet()) {
                List<NodeWebPageMain2> nodeWebPageMain21 = keyWord.getValue();
                nodeWebPageMain21.remove(nodeWebPageMain2);
            }
        }
    }
}
