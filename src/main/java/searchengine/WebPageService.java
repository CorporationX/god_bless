package searchengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebPageService {
    private static Map<String, List<WebPage>> index = new HashMap<>();
    private static Map<String, List<String>> urlAndKeywords = new HashMap<>();

    public static void indexTheWebPage(WebPage webPage) {
        if (urlAndKeywords.containsKey(webPage.getUrl())) {
            return;
        }
        List<String> keywordsByNewUrl = new ArrayList<>();

        String[] words = webPage.getContent().split("\\P{L}+");
        Set<String> uniqueKeywords = new HashSet<>(Arrays.asList(words));
        for (var keyword : uniqueKeywords) {
            if (index.get(keyword) != null) {
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
