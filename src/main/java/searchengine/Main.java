package searchengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, List<WebPage>> index = new HashMap<>();
    private static Map<String, List<String>> urlAndKeywords = new HashMap<>();

    public static void main(String[] args) {
        indexTheWebPage(new WebPage("url1", "title1", "hello, world!"));
        indexTheWebPage(new WebPage("url1", "title1", "hello, world!"));
        indexTheWebPage(new WebPage("url2", "title2", "hello, again!"));

        System.out.println(getWebPagesByKeyword("hello"));
        System.out.println(getWebPagesByKeyword("world"));
        System.out.println(getWebPagesByKeyword("again"));

        removeWebPageByUrl("url1");
        System.out.println(getWebPagesByKeyword("hello"));
        System.out.println(getWebPagesByKeyword("world"));

        indexTheWebPage(new WebPage("url1", "title1", "hello, world!"));
        System.out.println(getWebPagesByKeyword("hello"));
        System.out.println(getWebPagesByKeyword("world"));
    }

    public static void indexTheWebPage(WebPage webPage) {
        if (urlAndKeywords.containsKey(webPage.getUrl())) {
            return;
        }
        List<String> keywordsByNewUrl = new ArrayList<>();

        String[] words = webPage.getContent().split("\\P{L}+");
        Set<String> uniqueKeywords = new HashSet<>(Arrays.asList(words));
        for (var keyword : uniqueKeywords) {
            if (index.containsKey(keyword)) {
                index.get(keyword).add(webPage);
            } else {
                List<WebPage> newKeywordWebPages = new ArrayList<>();
                newKeywordWebPages.add(webPage);
                index.put(keyword, newKeywordWebPages);
            }
            keywordsByNewUrl.add(keyword);
        }
        urlAndKeywords.put(webPage.getUrl(), keywordsByNewUrl);
    }

    public static List<WebPage> getWebPagesByKeyword(String keyword) {
        return index.get(keyword);
    }

    public static void removeWebPageByUrl(String url) {
        for (var keyword : urlAndKeywords.get(url)) {
            for (int i = 0; i < index.get(keyword).size(); i++) {
                if (index.get(keyword).get(i).getUrl().equals(url)) {
                    index.get(keyword).remove(i);
                    if (index.get(keyword).isEmpty()) {
                        index.remove(keyword);
                    }
                    break;
                }
            }
        }
        urlAndKeywords.remove(url);
    }
}
