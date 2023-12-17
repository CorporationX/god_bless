package faang.school.godbless.java_hashmap.google_mini_search_engine;

import java.util.*;

public class Main {

    private static final Map<String, List<WebPage>> mapWebPage = new HashMap<>();

    public static void main(String[] args) {

        WebPage webPage1 = new WebPage("https://www.wikipedia.org", "Wikipedia", "The Free Encyclopedia");
        WebPage webPage2 = new WebPage("https://www.github.com", "GitHub", "Where the world builds software");
        WebPage webPage3 = new WebPage("https://www.stackoverflow.com", "Stack Overflow", "Where Developers Learn, Share, & Build Careers");
        WebPage webPage4 = new WebPage("https://www.medium.com", "Medium", "Where good ideas find you");
        WebPage webPage5 = new WebPage("https://www.twitter.com", "Twitter", "It's what's happening / Twitter");
        WebPage webPage6 = new WebPage("https://www.reddit.com", "Reddit", "Dive into anything");
        WebPage webPage7 = new WebPage("https://www.quora.com", "Quora", "A place to share knowledge and better understand the world");
        WebPage webPage8 = new WebPage("https://www.linkedin.com", "LinkedIn", "Connect, learn, and grow with professional community");
        WebPage webPage9 = new WebPage("https://www.netflix.com", "Netflix", "Watch TV Shows Online, Watch Movies Online");
        WebPage webPage10 = new WebPage("https://www.amazon.com", "Amazon", "Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

        indexing(webPage1);
        indexing(webPage2);
        indexing(webPage3);
        indexing(webPage4);
        indexing(webPage5);
        indexing(webPage6);
        indexing(webPage7);
        indexing(webPage8);
        indexing(webPage9);
        indexing(webPage10);


        List<WebPage> webPageList = getListWebPage("Where");

        removeWebPage("https://www.github.com");


    }


    static void indexing(WebPage webPage) {
        if (webPage == null) throw new IllegalArgumentException("args is null");

        String[] keyWords = webPage.getContent().split("\s");
        for (int i = 0; i < keyWords.length; i++) {
            mapWebPage.putIfAbsent(keyWords[i], new ArrayList<>());
            mapWebPage.get(keyWords[i]).add(webPage);
        }
    }

    static List<WebPage> getListWebPage(String keyWord) {
        List<WebPage> webPageList = mapWebPage.getOrDefault(keyWord, Collections.emptyList());
        if (webPageList == null || webPageList.isEmpty()) {
            System.out.println("Web pages not found");
        }
        return webPageList;
    }

    static void removeWebPage(String url) {
        Iterator<Map.Entry<String, List<WebPage>>> it = mapWebPage.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<WebPage>> entry = it.next();
            Iterator<WebPage> webPageIt = entry.getValue().iterator();
            while (webPageIt.hasNext()) {
                WebPage webPage = webPageIt.next();
                if (webPage.getUrl().equals(url)) {
                    webPageIt.remove();
                }
            }
        }
    }
}
