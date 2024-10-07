package school.faang.google;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class Google {
    private Map<String, List<WebPage>> pages = new HashMap<>();
    private Set<WebPage> existingPages = new HashSet<>();

    public void indexWebPage(WebPage webPage) {
        if (existingPages.contains(webPage)) {
            return;
        }
        String content = webPage.getContent().replaceAll("[^a-zA-Zа-яА-ЯёЁ0-9\\s]", "");
        String[] words = content.split("\\s+");
        for (String word : words) {
            pages.computeIfAbsent(word.toLowerCase(), key -> new ArrayList<>()).add(webPage);
        }
        existingPages.add(webPage);
    }

    public List<WebPage> search(String request) {
        return pages.getOrDefault(request.toLowerCase(), Collections.emptyList());
    }

    public void removePageFromIndex(String url) {
        removeWebPageFromExisting(url);
        removeEmptyPageRequests(url);
    }

    private void removeWebPageFromExisting(String url) {
        existingPages.removeIf(page -> page.getUrl().equals(url));
    }

    private void removeEmptyPageRequests(String url) {
        pages.entrySet().removeIf(entry -> {
            List<WebPage> webPages = entry.getValue();
            webPages.removeIf(page -> page.getUrl().equals(url));
            return webPages.isEmpty();
        });
    }
}
