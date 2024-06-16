package faang.school.godbless.task11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static HashMap<String, List<WebPage>> webPages = new HashMap<>();

    public static void main(String[] args) {
        WebPage page1 = new WebPage("https://example.com", "title1", "Welcome to Example");
        WebPage page2 = new WebPage("https://test.com", "title2", "Test Page");
        WebPage page3 = new WebPage("https://another.com", "title3", "Another Page");

        indexPages(page1);
        indexPages(page2);
        indexPages(page3);

        List<WebPage> pagesWithKeyword = getWebPages("Example");
        System.out.println("Pages with keyword 'Example':");
        for (WebPage page : pagesWithKeyword) {
            System.out.println(page.getUrl());
        }

        removeWebPages("https://test.com");

        pagesWithKeyword = getWebPages("Test");
        System.out.println("Pages with keyword 'Test' after removal:");
        for (WebPage page : pagesWithKeyword) {
            System.out.println(page.getUrl());
        }
    }

    public static void indexPages(WebPage page) {
        for (String keyWord : page.getContent().split(" ")) {
            webPages.computeIfAbsent(keyWord, k -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> getWebPages(String keyWord) {
        return webPages.get(keyWord);
    }

    public static void removeWebPages(String url) {
        for (Map.Entry<String, List<WebPage>> entry : webPages.entrySet()) {
            entry.getValue().removeIf(page -> page.getUrl().equals(url));
        }
    }
}
