package dima.evseenko.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class WebPageService {
    private final Map<String, List<WebPage>> pages = new HashMap<>();

    public void addWebPage(WebPage page) {
        if (Objects.nonNull(page)) {
            getKeywords(page).forEach(word -> pages.computeIfAbsent(word, k -> new ArrayList<>()).add(page));
        }
    }

    public void addWebPages(List<WebPage> pages) {
        if (Objects.nonNull(pages)) {
            pages.forEach(this::addWebPage);
        }
    }

    public List<WebPage> findWebPages(String keyword) {
        return keyword == null ? null : pages.get(keyword.toLowerCase());
    }

    public void deleteWebPage(WebPage page) {
        getKeywords(page).forEach(word -> {
            if (pages.containsKey(word)) {
                pages.get(word).remove(page);
            }
        });
    }

    public void deleteWebPageByUrl(String url) {
        WebPage page = null;
        for (Map.Entry<String, List<WebPage>> entry : pages.entrySet()) {
            for (WebPage webPage : entry.getValue()) {
                if (webPage.getUrl().equals(url)) {
                    page = webPage;
                }
            }
        }
        if (page != null) {
            deleteWebPage(page);
        }
    }

    private Set<String> getKeywords(WebPage webPage) {
        String keywords = webPage.getTitle() + " " + webPage.getContent();
        keywords = keywords.replace("-", " ");
        keywords = keywords.replaceAll("[(\\\\s,.\\\"!?:';)]+", "");

        return new HashSet<>(List.of(keywords.trim().toLowerCase().split(" ")));
    }

    public void printWebPages() {
        pages.forEach((word, page) -> System.out.println(word + ": " + page));
        System.out.println();
    }
}
