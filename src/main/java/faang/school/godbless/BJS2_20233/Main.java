package faang.school.godbless.BJS2_20233;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> keywordVsWebpages = new HashMap<>();

    public static void main(String[] args) {
        indexWebPage(new WebPage("books.com", "books", "free book library"));
        indexWebPage(new WebPage("youtube.com", "youtube", "huge free video hosting"));
        indexWebPage(new WebPage("steam.com", "steam", "huge game library"));

        for (WebPage webPage : findWebPages("free")) {
            System.out.println(webPage);
        }
        System.out.println();

        deleteWebPage("youtube.com");

        for (WebPage webPage : findWebPages("free")) {
            System.out.println(webPage);
        }
    }

    private static void indexWebPage(WebPage page) {
        if (page == null) throw new IllegalArgumentException("Argument 'page' must not be null");

        for (String word : page.getContent().split(" ")) {
            keywordVsWebpages.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    private static List<WebPage> findWebPages(String keyword) {
        return keywordVsWebpages.getOrDefault(keyword, new ArrayList<>());
    }

    private static void deleteWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : keywordVsWebpages.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
