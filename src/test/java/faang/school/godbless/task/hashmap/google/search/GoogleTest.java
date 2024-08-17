package faang.school.godbless.task.hashmap.google.search;

import faang.school.godbless.task.hashmap.google.search.Google;
import faang.school.godbless.task.hashmap.google.search.WebPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GoogleTest {
    WebPage webPage1 = new WebPage("http://somepage.com", "Some page", "This page contains some text!");
    WebPage webPage2 = new WebPage("http://second.com", "Second", "Hello-text!");

    private Google google;

    @BeforeEach
    void setUp() {
        google = new Google(new HashMap<>(), new HashMap<>());
    }

    @Test
    @DisplayName("Scan web page")
    void testScanWebPage() {
        google.scanWebPage(webPage1);
        google.getWordAndWebPagesListMap().entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " " + entry.getValue()));
        System.out.println(google.getUrlAndWordsMap());
    }

    @Test
    @DisplayName("Find web pages by word")
    void testFindWebPagesByWord() {
        List<WebPage> expectedWebPages = List.of(webPage1, webPage2);
        google.scanWebPage(webPage1);
        google.scanWebPage(webPage2);
        assertEquals(expectedWebPages, google.findWebPagesByWord("text"));
    }

    @Test
    @DisplayName("Delete web page by url")
    void testDeleteWebPageByUrl() {
        google.scanWebPage(webPage1);
        google.scanWebPage(webPage2);
        google.deleteWebPageByUrl(webPage1.url());
        assertFalse(google.findWebPagesByWord("text").contains(webPage1));
    }
}
