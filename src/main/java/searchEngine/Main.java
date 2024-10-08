package searchEngine;

import java.util.*;

public class Main {
    private static Map<String, List<WebPage>> indexedWebpagesDB = new HashMap<>();

    public static void main(String[] args) {
        WebPage facebook = new WebPage("facebook.com", "facebook", "Facebook connects each person whever they reside");
        WebPage google = new WebPage("google.com", "google", "Google connects each person whever they reside");
        indexWebpage(facebook);
        indexWebpage(google);

        for (Map.Entry<String, List<WebPage>> entry : indexedWebpagesDB.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("=======================================================");

        List<WebPage> keywordRelatedPages = searchWebpage("conn");
        for (WebPage webPage : keywordRelatedPages) {
            System.out.println(webPage.getTitle());
        }

        System.out.println("=======================================================");

        removeWebpage("google.com");

        for (Map.Entry<String, List<WebPage>> entry : indexedWebpagesDB.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void indexWebpage(WebPage webPage) {
        List<String> list = new ArrayList<>(Arrays.asList(webPage.getContent().split("\\W+")));
        for (String contentWord : list) {
            indexedWebpagesDB.putIfAbsent(contentWord, new ArrayList<>());
            if (indexedWebpagesDB.containsKey(contentWord)) {
                indexedWebpagesDB.get(contentWord).add(webPage);
            }
        }
    }

    public static List<WebPage> searchWebpage(String keyword) {
        List<WebPage> webpages = new ArrayList<>();
        for (Map.Entry<String, List<WebPage>> entry : indexedWebpagesDB.entrySet()) {
            if (entry.getKey().contains(keyword)) {
                webpages.addAll(entry.getValue());
            }
        }
        return webpages;
    }

    public static void removeWebpage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : indexedWebpagesDB.entrySet()) {
            Iterator<WebPage> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                WebPage webPage = iterator.next();
                if (webPage.getUrl().equals(url)) {
                    iterator.remove();
                }
            }
        }
    }
}
