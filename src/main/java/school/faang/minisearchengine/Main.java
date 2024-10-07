package school.faang.minisearchengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webPageMap = new HashMap<>();
    public static void main(String[] args) {
        indexNewWebPage("http://werobots.gotingfar.com", "First article", "Вы решили создать простой поисковой движок, который будет индексировать веб-страницы и позволять пользователям будет быстро находить страницы по ключевым словам");
        System.out.println(webPageMap);

        System.out.println(" ");
        System.out.println("Поиск");
        List<String> searchMethodResult = new ArrayList<>();
        searchMethodResult = searchingWebPage("будет");
        System.out.println(searchMethodResult);

        System.out.println(" ");
        System.out.println("Удаление");
        deleteWebPage("http://werobots.gotingfar.com");
        System.out.println(webPageMap);

    }
    private static void indexNewWebPage(String url, String title, String content) {
        List<WebPage> webPages = new ArrayList<>();
        webPages.add(new WebPage(url, title, content));

        String[] words = content.split("\\\\s|!|;|-|[0-9]| |\\\\.");
        for (String word : words) {
            webPageMap.put(word, webPages);
        }
    }

    private static List<String> searchingWebPage(String keyWord) {
        List<String> webPages = new ArrayList<>();
        for (Map.Entry<String, List<WebPage>> entry : webPageMap.entrySet()) {
            if (entry.getKey().equals(keyWord)) {
                for (WebPage elements : entry.getValue()) {
                    webPages.add(elements.getUrl());
                }
            }
        }
        return webPages;
    }

    private static void deleteWebPage(String url) {
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, List<WebPage>> entry : webPageMap.entrySet()) {
            for (WebPage elements : entry.getValue()) {
                if (elements.getUrl().equals(url)) {
                    keys.add(entry.getKey());
                }
            }
        }

        for (String key : keys) {
            webPageMap.remove(key);
        }
    }
}
