package faang.school.godbless.google.search.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<WebPage> webPages = new ArrayList<>();
        Map<String, List<WebPage>> webPagesSortedList = new HashMap<>();

        webPages.add(new WebPage("javarush.com", "java intro", "best java, introduction"));
        webPages.add(new WebPage("javamagics.com", "JAVA Magics", "best java intro course"));
        webPages.add(new WebPage("javaguru.com", "learn java with me", "let's get deep into Java."));
        webPages.add(new WebPage("vk.com", "javascript intro", "best. javascript. intro"));
        webPages.add(new WebPage("learn-javascript.com", "javascript learning", "best javascript tutorial"));

        webPagesSortedList.putAll(WebPage.indexWebPages(webPages));

        System.out.println("\nSorted map output:\n");
        webPagesSortedList
                .forEach((keyword, sortedWebPages) -> {
                    System.out.print(keyword + ": ");
                    for (WebPage webPage : sortedWebPages) {
                        System.out.print(" | " + webPage.url + " | ");
                    }
                    System.out.println();
                });

        System.out.println("\nWebsites filtered by keyword \"Java\":\n");
        for (WebPage webPageWithKeyword : WebPage.getWebPageByKeyword("JAVA")) {
            System.out.print(" | " + webPageWithKeyword.url + " | ");
        }
        System.out.println();

        System.out.println("\nSame websites without removed ones:\n");

        WebPage.removeWebPageFromIndexByUrl("javarush.com");
        WebPage.removeWebPageFromIndexByUrl("javaguru.com");
        for (WebPage webPageWithKeyword : WebPage.getWebPageByKeyword("java")) {
            System.out.print(webPageWithKeyword.url + " ");
        }
        System.out.println();
    }
}
