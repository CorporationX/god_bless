package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WebPageService {
    private static Map<String, List<WebPage>> webMap = new HashMap<>();
    private static Map<String, LinkedList<UrlValue>> urlMap = new HashMap<>();

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
    public void printAllWebs() {
        for (Map.Entry<String, List<WebPage>> entry : webMap.entrySet()) {
            System.out.println("Ключевое слово: " + entry.getKey() + " страницы: " + entry.getValue());
        }
    }

    public void printAllUrls() {
        for (Map.Entry<String, LinkedList<UrlValue>> entry : urlMap.entrySet()) {
            System.out.println("URL: " + entry.getKey() + " где находится: " + entry.getValue());
        }
    }

}
