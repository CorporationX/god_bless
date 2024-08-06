package google_search_engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final HashMap<String, List<WebPage>> indexingMap = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://leetcode.com/problems/two-sum/description/",
                "Two Sum","LeetCode task 'Two Sum'.");
        WebPage webPage2 = new WebPage("https://leetcode.com/problems/palindrome-number/description/",
                "Palindrome Number","LeetCode task 'Palindrome Number'.");
        List<WebPage> webPages = List.of(webPage1, webPage2);
        indexWebPages(webPages);
        System.out.println(getWebPagesByKeyword("LeetCode"));
        removeWebPageByUrl("https://leetcode.com/problems/two-sum/description/");
        System.out.println(getWebPagesByKeyword("LeetCode"));
    }

    public static void indexWebPage(WebPage webPage) {
        List<String> tokens = Arrays.stream(webPage.getContent().split(" "))
                .map(token -> token.replaceAll("[.,;:_']","")).toList();
        for (String token : tokens) {
            if (!indexingMap.containsKey(token)) {
                indexingMap.put(token, new ArrayList<>());
            }
            indexingMap.get(token).add(webPage);
        }
    }

    public static void indexWebPages(List<WebPage> webPages) {
        for (WebPage webPage : webPages) {
            indexWebPage(webPage);
        }
    }

    public static List<WebPage> getWebPagesByKeyword(String keyword) {
        return indexingMap.get(keyword);
    }

    public static void removeWebPageByUrl(String url) {
        for (String key : indexingMap.keySet()) {
            List<WebPage> webPages = indexingMap.get(key);
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }

}
