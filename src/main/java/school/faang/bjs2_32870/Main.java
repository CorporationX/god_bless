package school.faang.bjs2_32870;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> SEARCH_ENGINE = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://apteka.ru", "24-hour pharmacy \"AptekaRu\"", "The pharmacy is open 24/7. All medicines are available");
        WebPage webPage2 = new WebPage("https://astro.com", "Astronomy in simple terms", "Galaxy, Milky Way, Comet. What do these words tell you?");
        WebPage webPage3 = new WebPage("https://Eapteka.ru", "EApteka", "The same works 24/7. The same goes for all the medicines");

        indexingWebPage(webPage1);
        indexingWebPage(webPage2);
        indexingWebPage(webPage3);

        deletePage("https://apteka.ru");
        deletePage("https://Eapteka.ru");

        System.out.println(SEARCH_ENGINE);}

    private static void indexingWebPage(WebPage webPage) {
        List<String> keywords = List.of(webPage.getContent().split("[\\s.]+"));

        for (String keyword : keywords) {
            SEARCH_ENGINE.putIfAbsent(keyword, new ArrayList<>());
            SEARCH_ENGINE.get(keyword).add(webPage);
        }
    }

    private static List<WebPage> searchPagesByKeyword(String keyword) {
       return SEARCH_ENGINE.get(keyword);
    }

    private static void deletePage(String url) {
        List<String> searchedKeyword = new ArrayList<>();

        for (Map.Entry<String, List<WebPage>> entry : SEARCH_ENGINE.entrySet()) {
            for (WebPage webPage : entry.getValue()) {
                if (webPage.getUrl().equals(url)) {
                    searchedKeyword.add(entry.getKey());
                }
            }
        }
        for (String keyword : searchedKeyword) {
            SEARCH_ENGINE.remove(keyword);
        }
    }
}
