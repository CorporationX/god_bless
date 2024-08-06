package faang.school.godbless.google;

import faang.school.godbless.google.models.WebPage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static faang.school.godbless.google.services.WebPageService.*;

public class Main {

    public static HashMap<String, List<WebPage>> webPagesMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(webPagesMap);
        String content = """
                Overview
                In this article, we’ll see how to use HashMap in Java, and we’ll look at how it works internally.
                A class very similar to HashMap is Hashtable. Please refer to a couple of our other articles to learn more about the java.util.Hashtable class itself and the differences between HashMap and Hashtable.
                """;
        WebPage webPage = new WebPage("https://www.baeldung.com/java-hashmap", "A Guide to Java HashMap", content);

        System.out.println(Arrays.stream(content.split("[\\s,.]+")).distinct().count());

        addWebPageInMap(webPage);
        System.out.println(webPagesMap.keySet().size());
        System.out.println(webPagesMap);

        webPage = new WebPage("https://www.java.com/java-hashmap", "A Guide to Java HashMap", content);
        addWebPageInMap(webPage);
        System.out.println(webPagesMap.keySet().size());
        System.out.println(webPagesMap.keySet());

        System.out.println(webPagesMap);

        content = """
                HAH TEST
                """;
        webPage = new WebPage("https://www.test.com/heh", "TEST", content);
        addWebPageInMap(webPage);
        System.out.println(webPagesMap.keySet().size());

        System.out.println(webPagesMap);
        getWebPagesByKeyWord("TEST");
        getWebPagesByKeyWord("Overview");
        getWebPagesByKeyWord("ASdasdfdsafxdcfv");

        deleteWebPageFromMap("https://www.baeldung.com/java-hashmap");
        System.out.println(webPagesMap);

    }
}
