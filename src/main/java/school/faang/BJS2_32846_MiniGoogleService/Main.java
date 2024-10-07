package school.faang.BJS2_32846_MiniGoogleService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebService webService = new WebService();

        WebPage page1 = new WebPage("http://example.com/page1", "Example Page 1", "This is an example content with keywords.");
        WebPage page2 = new WebPage("http://example.com/page2", "Example Page 2", "Another example with different keywords.");
        WebPage page3 = new WebPage("http://example.com/page3", "Example Page 3", "Keywords and more keywords.");

        webService.indexWebPage(page1);
        webService.indexWebPage(page2);
        webService.indexWebPage(page3);

        String searchWord = "keywords";
        List<WebPage> foundedPages = webService.getWebPages(searchWord);

        System.out.println("Pages containing the word '" + searchWord + "':");
        for (WebPage page : foundedPages) {
            System.out.println(page.getUrl() + ": " + page.getTitle());
        }

        foundedPages = webService.getWebPages("example");
        System.out.println("\nPages containing the word 'example' before removing 2nd page:");
        for (WebPage page : foundedPages) {
            System.out.println(page.getUrl() + ": " + page.getTitle());
        }

        webService.removeWebPage(page2.getUrl());

        foundedPages = webService.getWebPages("example");
        System.out.println("\nPages containing the word 'example' after removing 2nd page:");
        for (WebPage page : foundedPages) {
            System.out.println(page.getUrl() + ": " + page.getTitle());
        }
    }
}
