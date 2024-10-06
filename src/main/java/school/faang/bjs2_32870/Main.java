package school.faang.bjs2_32870;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> SEARCH_ENGINE = new HashMap<>();

    private Main() {
    }

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://apteka.ru", "Круглосуточная аптека \"АптекаRu\"", "Аптека работает 24/7. Есть все лекарства");
        WebPage webPage2 = new WebPage("https://astro.com", "Астрономия простым языком", "Галактика, Млечный путь, Комета. О чем вам говорят эти слова?");
        WebPage webPage3 = new WebPage("https://Eapteka.ru", "ЕАптека", "То же работает 24/7. То же есть все лекарства");

        indexingWebPage(webPage1);
        indexingWebPage(webPage2);
        indexingWebPage(webPage3);

        System.out.println(searchByKeyword("24/7"));
        System.out.println(searchByKeyword("Комета"));
    }

    private static void indexingWebPage(WebPage webPage) {
        List<String> keywords = List.of(webPage.getContent().split("[\\s.]+"));

        for (String keyword : keywords) {
            SEARCH_ENGINE.putIfAbsent(keyword, new ArrayList<>());
            SEARCH_ENGINE.get(keyword).add(webPage);
        }
    }

    private static List<WebPage> searchByKeyword(String keyword) {
        List<WebPage> sortedPages = new ArrayList<>();
        for (Map.Entry<String, List<WebPage>> page : SEARCH_ENGINE.entrySet()) {
            if (page.getKey().equals(keyword)) {
                sortedPages = page.getValue();
            }
        }
        return sortedPages;
    }
}
