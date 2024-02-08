package faang.school.godbless.searchengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    private static final Map<String, List<WebPage>> pages = new HashMap<>();

    public static void add(WebPage page) {
        String[] words = page.getContent().split(" ");
        for (var word : words) {
            List<WebPage> webPages = pages.get(word);
            if (webPages != null) {
                if (!webPages.contains(page)) {
                    webPages.add(page);
                }
            }
            else {
                List<WebPage> newPages = new ArrayList<>();
                newPages.add(page);
                pages.put(word, newPages);
            }
        }
    }

    public static Optional<List<WebPage>> search(String word) {
        return Optional.ofNullable(pages.get(word));
    }

    public static void delete(String url) {
        for (var pageList : pages.values()) {
            pageList.removeIf(page -> url.equals(page.getUrl()));
        }
    }
}
