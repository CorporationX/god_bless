package dima.evseenko.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Google {
    private final Map<String, List<WebPage>> pages = new HashMap<>();

    public void addWebPage(WebPage page) {
        validateWebPage(page);

        page.getKeywords().forEach(word -> pages.computeIfAbsent(word, k -> new ArrayList<>()).add(page));
    }

    public void addWebPages(List<WebPage> pages) {
        validateWebPages(pages);

        pages.forEach(this::addWebPage);
    }

    public List<WebPage> findWebPages(String keyword) {
        if(keyword == null) return null;
        return pages.get(keyword.toLowerCase());
    }

    public void deleteWebPage(WebPage page) {
        page.getKeywords().forEach(word -> {
            if(pages.containsKey(word)) {
                pages.get(word).remove(page);
            }
        });
    }

    public void deleteWebPageByUrl(String url) {
        WebPage page = null;
        for (Map.Entry<String, List<WebPage>> entry : pages.entrySet()) {
            for(WebPage webPage : entry.getValue()) {
                if(webPage.getUrl().equals(url)) {
                    page = webPage;
                }
            }
        }
        if(page != null) {
            deleteWebPage(page);
        }
    }

    private void validateWebPage(WebPage page) {
        if(page == null)
            throw new IllegalArgumentException("Page is null");
        if(page.getTitle() == null)
            throw new IllegalArgumentException("Page title is null");
        if(page.getContent() == null)
            throw new IllegalArgumentException("Page content is null");
        if(page.getKeywords() == null)
            throw new IllegalArgumentException("Page keywords is null");
        if(page.getUrl() == null)
            throw new IllegalArgumentException("Page url is null");
    }

    private void validateWebPages(List<WebPage> pages) {
        if(pages == null)
            throw new IllegalArgumentException("Pages is null");
    }

    public void printWebPages(){
        pages.forEach((word, page) -> System.out.println(word + ": " + page));
        System.out.println();
    }
}
