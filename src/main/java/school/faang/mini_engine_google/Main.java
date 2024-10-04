package school.faang.mini_engine_google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webPageList = new HashMap<>();

    public static void indexedWebPage(WebPage webPage) {
        String[] key = webPage.getContext().split(" ");
        for (String word : key) {
            webPageList.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
        webPageList.get(key).add(webPage);
    }

    public static List<WebPage> searchWebPage(String word) {

    }
}
