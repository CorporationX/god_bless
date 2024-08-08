package faang.school.godbless.google.services;

import faang.school.godbless.google.models.WebPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static faang.school.godbless.google.Main.webPagesMap;

public class WebPageService {

    public static void addWebPageInMap(WebPage webPage) {
        Arrays.stream(webPage.getContent().split("[\\s,.]+")).forEach(word -> {
            List<WebPage> webPagesInMap = new ArrayList<>();
            if (webPagesMap.containsKey(word)) {
                webPagesInMap = webPagesMap.get(word);
                if (!webPagesInMap.contains(webPage)) {
                    webPagesInMap.add(webPage);
                }
            } else {
                webPagesInMap.add(webPage);
                webPagesMap.put(word, webPagesInMap);
            }
        });
    }

    public static void getWebPagesByKeyWord(String keyWord) {
        if (webPagesMap.containsKey(keyWord)) {
            System.out.println("For key word " + keyWord + " founded next pages:");
            webPagesMap.get(keyWord).forEach(System.out::println);
        } else {
            System.out.println("No pages found for the keyword: " + keyWord);
        }
    }

    public static void deleteWebPageFromMap(String url) {
        for (List<WebPage> webPagesList : webPagesMap.values()) {
            webPagesList.removeIf(webPage -> webPage.getUrl().equalsIgnoreCase(url));
        }
    }
}
