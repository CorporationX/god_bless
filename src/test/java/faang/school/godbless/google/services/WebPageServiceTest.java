package faang.school.godbless.google.services;

import faang.school.godbless.google.models.WebPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static faang.school.godbless.google.services.WebPageService.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WebPageServiceTest {

    public final int ONE = 1;
    public final int TWO = 2;
    public final String WORD = "Overview";
    public final String CONTENT = """
            Overview
            In this article, we’ll see how to use HashMap in Java, and we’ll look at how it works internally.
            A class very similar to HashMap is Hashtable. Please refer to a couple of our other articles to learn more about the java.util.Hashtable class itself and the differences between HashMap and Hashtable.
            """;
    public final String TITLE = "A Guide to Java HashMap";
    public final String URL = "https://www.baeldung.com/java-hashmap";
    public final String URL_ANOTHER = "https://www.java.com/java-hashmap";

    public static HashMap<String, List<WebPage>> webPagesMap = new HashMap<>();

    @BeforeEach
    void init() {
        WebPage webPage = new WebPage(URL, TITLE, CONTENT);
        addWebPageInMap(webPage, webPagesMap);

        webPage = new WebPage(URL_ANOTHER, TITLE, CONTENT);
        addWebPageInMap(webPage, webPagesMap);
    }

    @Test
    void addWebPageInMapTest() {
        long countOfWordContent = Arrays.stream(CONTENT.split("[\\s,.]+")).distinct().count();
        assertEquals(webPagesMap.keySet().size(), countOfWordContent);

        WebPage webPage = null;
        addWebPageInMap(webPage, webPagesMap);
        System.out.println(webPagesMap);

        getWebPagesByKeyWord(null, webPagesMap);
    }

    @Test
    void deleteWebPageFromMapTest() {
        getWebPagesByKeyWord("Overview", webPagesMap);

        assertEquals(webPagesMap.get(WORD).size(), TWO);
        deleteWebPageFromMap(URL_ANOTHER, webPagesMap);
        assertEquals(webPagesMap.get(WORD).size(), ONE);

        getWebPagesByKeyWord("Overview", webPagesMap);
    }
}