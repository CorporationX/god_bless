package faang.school.godbless.bjs220404;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<WebPage>> indexedPages = new HashMap<>();
        SearchEngine searchEngine = new SearchEngine();

        WebPage page1 = new WebPage("https://example.com", "Example Title 1", "Java HashMap tutorial");
        WebPage page2 = new WebPage("https://sample.com", "Sample Title", "Java collections framework HashMap");
        WebPage page3 = new WebPage("https://another.com", "Another Title", "HashMap in Java with examples");
        WebPage page4 = new WebPage("https://site.com", "Site Title", "Learn Java programming and HashMap");
        WebPage page5 = new WebPage("https://test.com", "Test Title", "Introduction to Java HashMap");

        searchEngine.indexPage(indexedPages, page1);
        searchEngine.indexPage(indexedPages, page2);
        searchEngine.indexPage(indexedPages, page3);
        searchEngine.indexPage(indexedPages, page4);
        searchEngine.indexPage(indexedPages, page5);

        System.out.println(searchEngine.search(indexedPages, "java"));
        searchEngine.deleteWebPage(indexedPages, "https://another.com");
        System.out.println(searchEngine.search(indexedPages, "java"));
    }
}
