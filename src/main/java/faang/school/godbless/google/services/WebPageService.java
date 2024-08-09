package faang.school.godbless.google.services;

import faang.school.godbless.google.models.WebPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WebPageService {

    public static void addWebPageInMap(WebPage webPage, HashMap<String, List<WebPage>> webPagesMap) {
        Arrays.stream(webPage.getContent().split("[\\s,.]+"))
                .forEach(word -> webPagesMap.computeIfAbsent(word, v -> new ArrayList<>()).add(webPage));
    }

    public static void getWebPagesByKeyWord(String keyWord, HashMap<String, List<WebPage>> webPagesMap) {
        if (webPagesMap.containsKey(keyWord)) {
            System.out.println("For key word " + keyWord + " founded next pages:");
            webPagesMap.get(keyWord).forEach(System.out::println);
        } else {
            System.out.println("No pages found for the keyword: " + keyWord);
        }
    }

    public static void deleteWebPageFromMap(String url, HashMap<String, List<WebPage>> webPagesMap) {
        for (List<WebPage> webPagesList : webPagesMap.values()) {
            webPagesList.removeIf(webPage -> webPage.getUrl().equalsIgnoreCase(url));
        }
    }
}
