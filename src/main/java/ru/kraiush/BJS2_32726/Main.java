package ru.kraiush.BJS2_32726;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> INDEXED_WEB_PAGES = new HashMap<>();

    private static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent()
                .replaceAll("[^a-zA-Z ']", "")
                .replaceAll("'", " ")
                .toLowerCase()
                .split("\\s+");
        for (String word : words) {
            INDEXED_WEB_PAGES.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    private static List<WebPage> findWebPagesByKeyWord(String keyWord) {
        return INDEXED_WEB_PAGES.get(keyWord.toLowerCase());
    }

    private static void deleteWebPageFromIndexByUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : INDEXED_WEB_PAGES.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("http://webpage1", "WebPage1", "Java is a powerful language; it’s widely used!");
        WebPage webPage2 = new WebPage("http://webpage2", "WebPage2", "Can you believe Java was created in 1995?");
        WebPage webPage3 = new WebPage("http://webpage3", "WebPage3", "Java's Garbage Collector helps manage memory, doesn't it?");
        WebPage webPage4 = new WebPage("http://webpage4", "WebPage4", "Learn Java, build applications, and start your developer career.");
        WebPage webPage5 = new WebPage("http://webpage5", "WebPage5", "Developers use Java for web, mobile, and desktop applications.");
        WebPage webPage6 = new WebPage("http://webpage6", "WebPage6", "Write once, run anywhere is Java's core philosophy.");
        WebPage webPage7 = new WebPage("http://webpage7", "WebPage7", "Java supports object-oriented principles: inheritance, encapsulation, polymorphism.");
        WebPage webPage8 = new WebPage("http://webpage8", "WebPage8", "Are you familiar with the JVM and JRE?");

        indexWebPage(webPage1);
        indexWebPage(webPage2);
        indexWebPage(webPage3);
        indexWebPage(webPage4);
        indexWebPage(webPage5);
        indexWebPage(webPage6);
        indexWebPage(webPage7);
        indexWebPage(webPage8);

        for (Map.Entry<String, List<WebPage>> entry : INDEXED_WEB_PAGES.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(findWebPagesByKeyWord("java"));
        deleteWebPageFromIndexByUrl("http://webpage3");

        for (Map.Entry<String, List<WebPage>> entry : INDEXED_WEB_PAGES.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
