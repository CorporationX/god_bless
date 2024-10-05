package school.faang.searchengine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, List<WebPage>> INDEX_TO_PAGES = new HashMap<>();

    public static void main(String[] args) {
        WebPage page1 = new WebPage("https://whatever.com", "What?", "hello world");
        WebPage page2 = new WebPage("https://cooking.com", "How to cook", "hello again");
        addPageToIndex(page1);
        addPageToIndex(page2);
        System.out.println(getWebPagesFromIndex("hello"));
        removePageFromIndex("https://whatever.com");
        System.out.println(getWebPagesFromIndex("hello"));
    }

    public static void addPageToIndex(WebPage page) {
        if (page == null) {
            throw new IllegalArgumentException("Page cannot be null");
        }
        for (String index : page.getContent().split(" ")) {
            List<WebPage> indexedPages = INDEX_TO_PAGES.computeIfAbsent(index, k -> new LinkedList<>());
            if (!indexedPages.contains(page)) {
                indexedPages.add(page);
            }
        }
    }

    public static List<WebPage> getWebPagesFromIndex(String index) {
        return INDEX_TO_PAGES.get(index);
    }

    public static void removePageFromIndex(String url) {
        for (List<WebPage> indexedPages : INDEX_TO_PAGES.values()) {
            Iterator<WebPage> iterator = indexedPages.iterator();
            while (iterator.hasNext()) {
                WebPage page = iterator.next();
                if (page.getUrl().equals(url)) {
                    iterator.remove();
                    break;
                }
            }
        }
    }
}
