package GoogleEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebPageService {

    public static void addPage (WebPage page, Map<String, List<WebPage>> pagesMap) {
        String[] words = page.getContent().split("[^\\p{L}\\p{Nd}]+");
        for (String word : words) {
            pagesMap.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> findByWord (String word, Map<String, List<WebPage>> pagesMap) {
        return pagesMap.get(word);
    }

    public static void removeByUrl (String url, Map<String, List<WebPage>> pagesMap) {
        pagesMap.forEach((k, v) -> {
            v.removeIf(w -> w.getUrl().equals(url));
        });
        pagesMap.values().removeIf(List::isEmpty);
    }

    public static void printPages (Map<String, List<WebPage>> pagesMap) {
        pagesMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
