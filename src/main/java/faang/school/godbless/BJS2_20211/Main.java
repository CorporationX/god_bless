package faang.school.godbless.BJS2_20211;

import java.util.*;

public class Main {
    private static Map<String, NodeWebPageLinkedList> mapIndex = new HashMap<>();
    private static Set<WebPage> setIndex = new HashSet<>();
    private static Map<String, List<NodeWebPageLinkedList.NodeWebPage>> listNodesQuickRemove = new HashMap<>();

    public static void main(String[] args) {
        indexWebPage(new WebPage("https://ya.ru", "Yandex", "java hello"));
        indexWebPage(new WebPage("https://google.com", "Google", "java google"));
        indexWebPage(new WebPage("https://netflix.com", "Netflix", "hello"));
        indexWebPage(new WebPage("https://uber.com", "Uber", "java yrdy"));
        indexWebPage(new WebPage("https://amazon.com", "Amazon", "else amazing hello something"));
        for (var entry : mapIndex.entrySet()) {
            System.out.println("Index: " + entry.getKey());
            entry.getValue().printList();
        }
        System.out.println("===================");
        System.out.println("Search by word");
        List<WebPage>listPages = searchPageByWord("hello");
        for (WebPage page : listPages) {
            System.out.println(page.getTitle());
        }
        removeByUrl("https://ya.ru");
        removeByUrl("https://amazon.com");
        System.out.println("After remove");
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
        for (NodeWebPageLinkedList.NodeWebPage nodeWebPage : list) {
            NodeWebPageLinkedList myList = nodeWebPage.getMyList();
            if (nodeWebPage.getRightNode() == null && nodeWebPage.getLeftNode() == null) {
                nodeWebPage.getMyList().setTail(null);
                nodeWebPage.getMyList().setHead(null);
                myList.setSize(myList.getSize() - 1);
            } else if (nodeWebPage.getRightNode() != null && nodeWebPage.getLeftNode() != null) {
                nodeWebPage.getRightNode().setLeftNode(nodeWebPage.getLeftNode());
                nodeWebPage.getLeftNode().setRightNode(nodeWebPage.getRightNode());
                nodeWebPage.setLeftNode(null);
                nodeWebPage.setRightNode(null);
                myList.setSize(myList.getSize() - 1);
            } else if (nodeWebPage.getRightNode() == null) {
                nodeWebPage.getMyList().setTail(nodeWebPage.getLeftNode());
                nodeWebPage.getLeftNode().setRightNode(null);
                nodeWebPage.setLeftNode(null);
                myList.setSize(myList.getSize() - 1);
            } else if (nodeWebPage.getLeftNode() == null) {
                nodeWebPage.getMyList().setHead(nodeWebPage.getRightNode());
                nodeWebPage.getRightNode().setLeftNode(null);
                nodeWebPage.setRightNode(null);
                myList.setSize(myList.getSize() - 1);
            }
        }
        listNodesQuickRemove.remove(url);
        List<String> wordRemove = new ArrayList<>();
        for (var entry : mapIndex.entrySet()) {
            if (entry.getValue().getSize() == 0) {
                wordRemove.add(entry.getKey());
            }
        }
        for (String word : wordRemove) {
            mapIndex.remove(word);
        }
    }

    private static List<WebPage> searchPageByWord(String word) {
        for (var entry : mapIndex.entrySet()) {
            if (entry.getKey().equals(word)) {
                return entry.getValue().getListPages();
            }
        }
        return null;
    }
}
