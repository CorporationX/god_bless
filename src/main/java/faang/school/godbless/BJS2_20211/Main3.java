package faang.school.godbless.BJS2_20211;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main3 {
    private static Map<String, NodeWebPageLinkedList> mapIndex = new HashMap<>();
    private static Set<WebPage> setIndex = new HashSet<>();
    private static Map<String, List<NodeWebPageLinkedList.NodeWebPage>> listNodesQuickRemove = new HashMap<>();

    public static void main(String[] args) {
        indexWebPage(new WebPage("https://ya.ru", "Yandex", "java hello"));
        indexWebPage(new WebPage("https://google.com", "Google", "java google"));
        indexWebPage(new WebPage("https://netflix.com", "Netflix", "hello"));
        indexWebPage(new WebPage("https://uber.com", "Uber", "java yrdy"));
        indexWebPage(new WebPage("https://amazon.com", "Amazon", "else amazing hello something"));
        System.out.println("+_+_+_+_+_+_+_+_+");
        for (var entry : mapIndex.entrySet()) {
            System.out.println("Index: " + entry.getKey());
            entry.getValue().printList();
        }
        System.out.println("===================");
        removeByUrl("https://ya.ru");
        System.out.println("AFTER REMOVE");
        for (var entry : mapIndex.entrySet()) {
            System.out.println("Index: " + entry.getKey());
            entry.getValue().printList();
        }
    }

    private static void indexWebPage(WebPage webPage) {
        String[] contentByWords = webPage.getContent().split(" ");
        if (!setIndex.contains(webPage)) {
            setIndex.add(webPage);
            for (String word : contentByWords) {
                NodeWebPageLinkedList.NodeWebPage nodeToIndex = new NodeWebPageLinkedList.NodeWebPage(webPage);
                if (!mapIndex.containsKey(word)) {
                    NodeWebPageLinkedList nodeWebPageLinkedList = new NodeWebPageLinkedList() {{
                        add(nodeToIndex);
                    }};
                    mapIndex.put(word, nodeWebPageLinkedList);
                } else {
                    mapIndex.get(word).add(nodeToIndex);
                }
                if (!listNodesQuickRemove.containsKey(webPage.getUrl())) {
                    listNodesQuickRemove.put(webPage.getUrl(), new ArrayList<>() {{
                        add(nodeToIndex);
                    }});
                } else {
                    listNodesQuickRemove.get(webPage.getUrl()).add(nodeToIndex);
                }
            }
        }
    }

    public static void removeByUrl(String url) {
        List<NodeWebPageLinkedList.NodeWebPage> list = listNodesQuickRemove.get(url);
//        for (NodeWebPageLinkedList.NodeWebPage node : list) {
//            System.out.println("sdfg"+node);
//        }
        for (NodeWebPageLinkedList.NodeWebPage nodeWebPage : list) {
            if (nodeWebPage.getRightNode() != null && nodeWebPage.getLeftNode() != null) {
                nodeWebPage.getRightNode().setLeftNode(nodeWebPage.getLeftNode());
                nodeWebPage.getLeftNode().setRightNode(nodeWebPage.getRightNode());
                nodeWebPage.setLeftNode(null);
                nodeWebPage.setRightNode(null);
            } else if (nodeWebPage.getRightNode() == null) {
                nodeWebPage.getLeftNode().setRightNode(null);
                nodeWebPage.setLeftNode(null);
            } else if (nodeWebPage.getLeftNode() == null) {
                System.out.println("sad" +nodeWebPage.getWebPage().getTitle());
                System.out.println(nodeWebPage.getRightNode().getWebPage().getTitle());
                System.out.println(nodeWebPage.getLeftNode());

                System.out.println("l node" +nodeWebPage.getRightNode().getLeftNode());
                nodeWebPage.getRightNode().setLeftNode(null);
                System.out.println("l node" +nodeWebPage.getRightNode().getLeftNode());
                nodeWebPage.setRightNode(null);
            }
        }
        listNodesQuickRemove.remove(url);
    }
}
