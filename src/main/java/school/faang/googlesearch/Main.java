package school.faang.googlesearch;

import java.util.List;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the search engine
        SearchEngine searchEngine = new SearchEngine();

        // Create some web pages
        WebPage page1 = new WebPage("https://example.com", "Example Page", "This is a simple example page with content about Java and programming.");
        WebPage page2 = new WebPage("https://example.com/about", "About Us", "Learn more about our company, our mission, and our values.");
        WebPage page3 = new WebPage("https://example.com/contact", "Contact Us", "Get in touch with us through our contact form. We love hearing from customers.");

        // Index the web pages
        searchEngine.indexWebPage(page1);
        searchEngine.indexWebPage(page2);
        searchEngine.indexWebPage(page3);

        // Search for pages containing the keyword "example"
        List<WebPage> result = searchEngine.search("example");
        System.out.println("Search results for 'example':");
        for (WebPage page : result) {
            System.out.println(" - " + page.getTitle() + " (" + page.getUrl() + ")");
        }

        // Remove a page from the index
        searchEngine.removeWebPage("https://example.com");

        // Search for pages containing the keyword "example" again
        System.out.println("\nSearch results for 'example' after removal:");
        result = searchEngine.search("example");
        for (WebPage page : result) {
            System.out.println(" - " + page.getTitle() + " (" + page.getUrl() + ")");
        }

        // Print the current index (for debugging purposes)
        System.out.println("\nCurrent Index:");
        searchEngine.printIndex();
    }
}