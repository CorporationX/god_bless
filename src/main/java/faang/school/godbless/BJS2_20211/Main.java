package faang.school.godbless.BJS2_20211;

import java.util.*;

public class Main {
    private static final Map<String, NodeWebPageLinkedList> mapIndex = new HashMap<>();
    private static final Set<WebPage> setIndex = new HashSet<>();
    private static final Map<String, List<NodeWebPageLinkedList.NodeWebPage>> listNodesQuickRemove = new HashMap<>();

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

        List<WebPage> listSearchByWord = searchPageByWord("hello");
        if (listSearchByWord != null) {
            for (WebPage page : listSearchByWord) {
                System.out.println(page.getTitle());
            }
        } else {
            System.out.println("Can't find any web page");
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
            } else {
                nodeWebPage.getMyList().setHead(nodeWebPage.getRightNode());
                nodeWebPage.getRightNode().setLeftNode(null);
                nodeWebPage.setRightNode(null);
                myList.setSize(myList.getSize() - 1);
            }
        }
        listNodesQuickRemove.remove(url);
        mapIndex.entrySet().removeIf(value -> value.getValue().getSize() == 0);
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
