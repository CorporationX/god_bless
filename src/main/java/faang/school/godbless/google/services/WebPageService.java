package faang.school.godbless.google.services;

import faang.school.godbless.google.models.WebPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WebPageService {

    public static void addWebPageInMap(WebPage webPage, Map<String, List<WebPage>> webPagesMap) {
        if (webPage != null) {
            Arrays.stream(webPage.getContent().split("[\\s,.]+"))
                    .forEach(word -> webPagesMap.computeIfAbsent(word, v -> new ArrayList<>()).add(webPage));
        }
    }

    public static void getWebPagesByKeyWord(String keyWord, Map<String, List<WebPage>> webPagesMap) {
        if (webPagesMap.containsKey(keyWord)) {
            System.out.println("For key word " + keyWord + " founded next pages:");
            webPagesMap.get(keyWord).forEach(System.out::println);
        } else {
            System.out.println("No pages found for the keyword: " + keyWord);
        }
    }

    public static void deleteWebPageFromMap(String url, Map<String, List<WebPage>> webPagesMap) {
        for (List<WebPage> webPagesList : webPagesMap.values()) {
            webPagesList.removeIf(webPage -> webPage.getUrl().equalsIgnoreCase(url));
        }
    }
}
