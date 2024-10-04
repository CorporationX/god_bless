package school.faang.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Google {
    private Map<String, List<WebPage>> pages;
    private Set<WebPage> existingPages;

    public Google() {
        this.pages = new HashMap<>();
        this.existingPages = new HashSet<>();
    }

    public void indexWebPage(WebPage webPage) {
        if (!existingPages.contains(webPage)) {
            String[] words = webPage.getContent().split("\\s+");
            for (String word : words) {
                pages.computeIfAbsent(word.toLowerCase(), key -> new ArrayList<>()).add(webPage);
            }
            existingPages.add(webPage);
        }
    }

    public List<WebPage> search(String request) {
        return pages.getOrDefault(request.toLowerCase(), Collections.emptyList());
    }

    public void removeWebPage(String url) {
        existingPages.removeIf(page -> page.getUrl().equals(url));
        for (List<WebPage> pages : pages.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}
