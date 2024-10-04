package googleSearchEngine;


import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    private static final Map<String, List<WebPage>> INDEX_WEB_PAGES = new HashMap<>();


    public static void main(String[] args) {
        WebPage google = new WebPage("https://www.google.com", "Google", "Hello world! Hello");
        WebPage yandex = new WebPage("https://www.yandex.ru", "Yandex", "Hello");
        WebPage mail = new WebPage("https://www.mail.ru", "Mail", "Plot (hello)");
        WebPage faangSchool = new WebPage("https://www.faang-school.com", "FaangSchool", "Plot");

        indexingWebPage(google);
        indexingWebPage(yandex);
        indexingWebPage(mail);
        indexingWebPage(faangSchool);

        INDEX_WEB_PAGES.forEach((k, v) -> System.out.println(k + " " + v.stream().map(WebPage::getTitle).toList()));

        System.out.println();
        System.out.println(findWebPages("hello").toString());

    }

    public static void indexingWebPage(WebPage webPage) {
        if (webPage == null) return;
        List<String> words = List.of(webPage.getContent().replaceAll("\\p{P}", " ").split(" "));
        for (String word : words) {
            if (!word.isEmpty()) {
                if (INDEX_WEB_PAGES.containsKey(word)) {
                    Set<WebPage> pages = new HashSet<>(INDEX_WEB_PAGES.get(word));
                    if (!pages.contains(webPage)) INDEX_WEB_PAGES.get(word).add(webPage);
                } else {
                    INDEX_WEB_PAGES.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
                }
            }
        }
    }

    public static List<WebPage> findWebPages(@NonNull String word) {
        return INDEX_WEB_PAGES.getOrDefault(word, List.of());
    }


}
