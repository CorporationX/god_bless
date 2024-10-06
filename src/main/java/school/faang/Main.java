package school.faang;

import school.faang.forthTask.SearchEngine;
import school.faang.forthTask.WebPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       googleSearchEngine();
    }

    public static void googleSearchEngine() {
        SearchEngine searchEngine = new SearchEngine();

        WebPage page1 = new WebPage("http://example1.com", "Example Page", "This is an example content with some example words.");
        WebPage page2 = new WebPage("http://example2.org", "Another Example", "Another example content with different words.");
        WebPage page3 = new WebPage("http://example3.org", "Third Example", "Third variant content with different words.");

        searchEngine.indexWebPage(page1);
        searchEngine.indexWebPage(page2);
        searchEngine.indexWebPage(page3);

        System.out.println("Set of indexes: " + searchEngine.getIndex().keySet());

        System.out.println("Search results for 'example':" + searchEngine.search("example").toString());

        for (WebPage page : searchEngine.search("example")) {
            System.out.println(page);
        }

        searchEngine.removeWebPage("http://example1.com");

        System.out.println("\nSearch results for 'example' after removal:");
        for (WebPage page : searchEngine.search("example")) {
            System.out.println(page);
        }
    }
}
