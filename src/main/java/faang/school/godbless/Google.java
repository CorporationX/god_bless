package faang.school.godbless;

import java.util.*;

public class Google {
    private final Map<String, List<WebPage>> index = new HashMap<>();

    public void indexWebPage(WebPage page) {
        if (page == null) {
            return;
        }

        String[] words = page.getContent().toLowerCase().split("\\W+");
        for (String word : words) {
            index.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    public List<WebPage> search(String keyword) {
        if (keyword == null) {
            return new ArrayList<>();
        }

        return index.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    public void removeWebPage(String url) {
        if (url == null) {
            return;
        }

        List<String> keysToRemove = new ArrayList<>();

        index.forEach((key, pages) -> {
            pages.removeIf(page -> page.getUrl().equals(url));

            if (pages.isEmpty()) {
                keysToRemove.add(key);
            }
        });

        keysToRemove.forEach(index::remove);
    }
}

