package school.faang.bjs2_32870;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> SEARCH_ENGINE = new HashMap<>();

    private Main() {
    }

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://apteka.ru", "24-hour pharmacy \"AptekaRu\"", "The pharmacy is open 24/7. All medicines are available");
        WebPage webPage2 = new WebPage("https://astro.com", "Astronomy in simple terms", "Galaxy, Milky Way, Comet. What do these words tell you?");
        WebPage webPage3 = new WebPage("https://Eapteka.ru", "EApteka", "The same works 24/7. The same goes for all the medicines");

        indexingWebPage(webPage1);
        indexingWebPage(webPage2);
        indexingWebPage(webPage3);

        System.out.println(searchPagesByKeyword("24/7"));
        System.out.println(searchPagesByKeyword("Milky Way"));
    }

    private static void indexingWebPage(WebPage webPage) {
        List<String> keywords = List.of(webPage.getContent().split("[\\s.]+"));

        for (String keyword : keywords) {
            SEARCH_ENGINE.putIfAbsent(keyword, List.of(webPage));
        }
    }

    private static List<WebPage> searchPagesByKeyword(String keyword) {
       return SEARCH_ENGINE.get(keyword);
    }
}
