package dima.evseenko.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WebPageService {
    private final Map<String, List<WebPage>> pages = new HashMap<>();

    public void addWebPage(WebPage page) {
        if (Objects.nonNull(page)) {
            page.getKeywords().forEach(word -> pages.computeIfAbsent(word, k -> new ArrayList<>()).add(page));
        }
    }

    public void addWebPages(List<WebPage> pages) {
        if (Objects.nonNull(pages)) {
            pages.forEach(this::addWebPage);
        }
    }

    public List<WebPage> findWebPages(String keyword) {
        if (keyword == null) return null;
        return pages.get(keyword.toLowerCase());
    }

    public void deleteWebPage(WebPage page) {
        page.getKeywords().forEach(word -> {
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

    public void printWebPages() {
        pages.forEach((word, page) -> System.out.println(word + ": " + page));
        System.out.println();
    }
}
