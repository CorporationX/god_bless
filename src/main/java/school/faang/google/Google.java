package school.faang.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Google {
    private Map<String, List<WebPage>> pages;

    public Google() {
        this.pages = new HashMap<>();
    }

    public void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\s+");
        for (String word : words) {
            pages.computeIfAbsent(word, key -> new ArrayList<>()).add(webPage);
        }
    }

    public List<WebPage> search(String request) {
        return pages.get(request);
    }

    public void removeWebPage(String url) {
        for (List<WebPage> pages : pages.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}
