package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webMap = new HashMap<>();
    private static Map<String, LinkedList<UrlValue>> urlMap = new HashMap<>();

    public static void main(String[] args) {

        WebPage wikiPage = new WebPage("https://ru.wikipedia.org/wiki/home_page",
                "Home_page", "Добро пожаловать в Википедию");

        WebPage youTubePage = new WebPage("https://www.youtube.com/playlist?list=WL",
                "playlist",
                "Одно или несколько видео удалены из плейлиста");
        WebPage vkPage = new WebPage("https://www.vk.ru",
                "Home_page",
                "Добро пожаловать в VK");
        WebPage instagramPage = new WebPage("https://www.instagram.com",
                "Home_page",
                "Добро пожаловать в Instagram");

        indexWeb(wikiPage);
        indexWeb(youTubePage);
        indexWeb(vkPage);
        indexWeb(instagramPage);

        for (Map.Entry<String, List<WebPage>> entry : webMap.entrySet()) {
            System.out.println("Ключивое слово " + entry.getKey() + " страницы " + entry.getValue());
        }

        System.out.println("===================================================");

        for (Map.Entry<String, LinkedList<UrlValue>> entry : urlMap.entrySet()) {
            System.out.println("URL: " + entry.getKey() + " где находится " + entry.getValue());
        }

        String keyWord = "Добро";
        System.out.println("Ключивое слово: " + keyWord + ", cписок страниц: " +
                searchPages(keyWord));

        System.out.println("=====================================================");
        deletePage(vkPage);

        for (Map.Entry<String, List<WebPage>> entry : webMap.entrySet()) {
            System.out.println("Ключивое слово " + entry.getKey() + " страницы " + entry.getValue());
        }
    }

    public static void indexWeb(WebPage webPage) {
        String content = webPage.getContent();
        String[] keyWords = content.split("[^\\p{L}\\p{N}]+");
        for (String word : keyWords) {
            List<WebPage> webPages = webMap.get(word);
            LinkedList<UrlValue> urlValues = urlMap.get(webPage.getUrl());

            if (webPages != null) {
                webMap.get(word).add(webPage);
            } else {
                webPages = new ArrayList<>();
                webPages.add(webPage);
                webMap.put(word, webPages);
            }
            if (urlMap.get(webPage.getUrl()) == null) {
                urlValues = new LinkedList<>();
                urlValues.add(new UrlValue(word, webPage));
                urlMap.put(webPage.getUrl(), urlValues);
            } else {
                urlMap.get(webPage.getUrl()).add(new UrlValue(word, webPage));
            }
        }
    }

    public static List<WebPage> searchPages(String str) {
        List<WebPage> list = webMap.get(str);
        return list;
    }

    public static void deletePage(WebPage pageToDelete) {
        LinkedList<UrlValue> deleteList = urlMap.get(pageToDelete.getUrl());

        if (deleteList != null) {
            List<UrlValue> valuesToRemove = new ArrayList<>();

            for (UrlValue urlValue : deleteList) {
                if (urlValue.getWebPage() == pageToDelete) {
                    valuesToRemove.add(urlValue);
                }
            }
            deleteList.removeAll(valuesToRemove);

            if (deleteList.isEmpty()) {
                urlMap.remove(pageToDelete.getUrl());
            }
        }
    }

}
