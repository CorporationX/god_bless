package school.faang.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, List<WebPage>> index = new HashMap<>();

    public static void main(String[] args) {
        WebPage page1 = new WebPage("https://www.google.com", "Google",
                "Google Search");
        WebPage page3 = new WebPage("https://www.google.com", "Google",
                "Google indexes");
        WebPage page2 = new WebPage("https://www.facebook.com", "Facebook",
                "Connect with friends and family");

        indexWebPage(page1);
        indexWebPage(page2);
        indexWebPage(page3);

        List<WebPage> results = findByWord("Google");
        showAllPages(results);
        System.out.println("-------------------------");
        allPagesUrl();
        removeWebPageByUrl("https://www.google.com");
        System.out.println("-------------------------");
        showAllPages(results);
    }

    private static void showAllPages(List<WebPage> results) {
        for (WebPage page : results) {
            System.out.println(page);
        }
    }

    private static void allPagesUrl() {
        index.forEach((key, value) -> System.out.printf("Key=%s: Value=%s\n",
                key, value));
    }

    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split(" ");
        for (String word : words) {
            index.computeIfAbsent(word, v -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findByWord(String word) {
        return index.getOrDefault(word.toLowerCase(), new ArrayList<>());
    }

    public static void removeWebPageByUrl(String url) {
        index.values().forEach(pages -> pages
                .removeIf(page -> page.getUrl().equals(url)));
    }
}
