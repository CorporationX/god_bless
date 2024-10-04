package school.faang.google;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Google {
    private Map<String, Set<WebPage>> pages;

    public Google() {
        this.pages = new HashMap<>();
    }

    public void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\s+");
        for (String word : words) {
            pages.computeIfAbsent(word.toLowerCase(), key -> new HashSet<>()).add(webPage);
        }
    }

    public Set<WebPage> search(String request) {
        return pages.getOrDefault(request, Collections.emptySet());
    }

    public void removeWebPage(String url) {
        for (Set<WebPage> pages : pages.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}
