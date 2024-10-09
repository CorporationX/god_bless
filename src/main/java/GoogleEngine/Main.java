package GoogleEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static GoogleEngine.WebPageService.*;

public class Main {
    public static final Map<String, List<WebPage>> pagesMap = new HashMap<>();

    public static void main(String[] args) {

        WebPage page1 = new WebPage("https://example.com/1",
                "Example 1", "First example of some content!");
        WebPage page2 = new WebPage("https://example.com/2",
                "Example 2", "Second example of some content!");

        addPage(page1, pagesMap);
        addPage(page2, pagesMap);

        List<WebPage> searchResult = findByWord("example", pagesMap);
        System.out.println("Found pages with a word \"example\"");
        for (WebPage webPage : searchResult) {
            System.out.println(webPage.getTitle() + " - " + webPage.getUrl());
        }
        System.out.println();

        removeByUrl("https://example.com/1", pagesMap);
        printPages(pagesMap);
    }
}