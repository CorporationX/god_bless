package school.faang.BJS2_32929;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        WebPage page1 = new WebPage("http://example.com/page1", "Example Page 1", "This is an example of a web page.");
        WebPage page2 = new WebPage("http://example.com/page2", "Example Page 2", "This page is about Java programming.");
        WebPage page3 = new WebPage("http://example.com/page3", "Example Page 3", "Learn Java and search engines.");

        searchEngine.indexWebPage(page1);
        searchEngine.indexWebPage(page2);
        searchEngine.indexWebPage(page3);

        System.out.println("Search results for 'Java':");
        List<WebPage> results = searchEngine.search("Java");
        for (WebPage page : results) {
            System.out.println(page);
        }

        searchEngine.removeWebPage(page2.getUrl());
        System.out.println("\nSearch results after removing page2:");
        results = searchEngine.search("Java");
        for (WebPage page : results) {
            System.out.println(page);
        }
    }
}
