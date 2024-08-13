package faang.school.godbless.googleSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<String, WebPagesLinkedList> keyWordsIndex = new HashMap<>();
    private static Map<String, WebPageAndList> urlIndex = new HashMap<>();

    public static void addWebPageToIndex(WebPage webPage) {
        String[] words = webPage.getContent().split("[^\\p{L}]+");
        for (String word : words) {
            Node node = new Node(webPage);
            keyWordsIndex.computeIfAbsent(word, k -> new WebPagesLinkedList()).addNode(node);
            urlIndex.computeIfAbsent(webPage.getUrl(), a -> new WebPageAndList(webPage, new ArrayList<>())).getNodesList().add(node);
        }
    }

    public static WebPagesLinkedList getList(String word) {
        return keyWordsIndex.get(word);
    }

    public static void removeWebPage(String url) {
        List<Node> nodesToRemove = urlIndex.get(url).getNodesList();
        for (Node node : nodesToRemove) {
            WebPagesLinkedList.remove(node);
        }
    }

    public static void printMap() {
        for (Map.Entry<String, WebPagesLinkedList> entry : keyWordsIndex.entrySet()) {
            System.out.println(entry.getKey());
            WebPagesLinkedList clonedList = entry.getValue().clone();
            System.out.println(clonedList.printLinkedList());
        }
    }

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("google.com", "Заголовок 1", "Создайте программу на Java для реализации своего простого поискового движка с использованием HashMap");
        WebPage webPage2 = new WebPage("youtube.com", "Заголовок 2", "Создайте программу на Java для реализации связного списка");
        WebPage webPage3 = new WebPage("ya.ru", "Заголовок 3", "Создайте любую программу с использованием HashMap");
        addWebPageToIndex(webPage1);
        addWebPageToIndex(webPage2);
        addWebPageToIndex(webPage3);
        printMap();
        removeWebPage("youtube.com");
        System.out.println("--------------------------------");
        printMap();
    }

}
