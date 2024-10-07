package school.faang.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public void removeWebPage(String url) {
        removeFromExistingPages(url);
        removeFromPages(url);
    }

    private void removeFromPages(String url) {
        findRequestsWithEmptyPagesAfterRemoval(url).forEach(pages::remove);
    }

    private Set<String> findRequestsWithEmptyPagesAfterRemoval(String url) {
        Set<String> requestToRemove = new HashSet<>();
        for (Map.Entry<String, List<WebPage>> entry : pages.entrySet()) {
            List<WebPage> webPages = entry.getValue();
            webPages.removeIf(page -> page.getUrl().equals(url));
            if (webPages.isEmpty()) {
                requestToRemove.add(entry.getKey());
            }
        }
        return requestToRemove;
    }

    private void removeFromExistingPages(String url) {
        existingPages.removeIf(page -> page.getUrl().equals(url));
    }
}
