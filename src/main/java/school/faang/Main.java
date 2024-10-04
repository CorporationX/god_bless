package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, List<WebPage>> INDEX_TO_PAGES = new HashMap<>();

    public static void main(String[] args) {

    }

    public static void addPageToIndex(WebPage page) {
        for (String word : page.getContent().split(" ")) {
            INDEX_TO_PAGES.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> getWebPagesFromIndex(String index) {
        return INDEX_TO_PAGES.get(index);
    }

    public static void removePageFromIndex(WebPage page) {
        for (String word : page.getContent().split(" ")) {
            if (INDEX_TO_PAGES.containsKey(word)) {
                INDEX_TO_PAGES.get(word).remove(page);
            }
        }
    }
}
