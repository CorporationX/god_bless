package faang.school.godbless.task.google.search;

import org.junit.jupiter.api.BeforeEach;
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
    void testScanWebPage() {
        google.scanWebPage(webPage1);
        google.getWordWebPagesListMap().entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " " + entry.getValue()));
        System.out.println(google.getUrlWordsMap());
    }

    @Test
    void testFindWebPagesByWord() {
        List<WebPage> expectedWebPages = List.of(webPage1, webPage2);
        google.scanWebPage(webPage1);
        google.scanWebPage(webPage2);
        assertEquals(expectedWebPages, google.findWebPagesByWord("text"));
    }

    @Test
    void testDeleteWebPageByUrl() {
        google.scanWebPage(webPage1);
        google.scanWebPage(webPage2);
        google.deleteWebPageByUrl(webPage1.url());
        assertFalse(google.findWebPagesByWord("text").contains(webPage1));
    }
}
