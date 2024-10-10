package school.faang.HashMap4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebPageOperator {
    public static void index(WebPage webPage, Map<String, List<WebPage>> webPageMap) {
        String[] words = webPage.getContent().toLowerCase().split("[,\\!\\?\\.\\\s]+");

        for (String word : words) {
            webPageMap.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> searchKeyWord(String keyWord, Map<String, List<WebPage>> webPageMap) {
        if (webPageMap.get(keyWord.toLowerCase()) != null) {
            return webPageMap.get(keyWord.toLowerCase());
        } else {
            return null;
        }
    }

    public static void deletePage(String url, Map<String, List<WebPage>> webPageMap) {
        for (var entry : webPageMap.entrySet()) {
            entry.getValue().remove(new WebPage(url));
        }
    }

    public static void printMap(Map<String, List<WebPage>> webPageMap) {
        for (var entry : webPageMap.entrySet()) {
            System.out.println("Word: " + entry.getKey() + "\nPages: ");
            printWebPageList(entry.getValue());
        }
    }

    public static void printWebPageList(List<WebPage> webPageList) {
        if (webPageList != null) {
            for (WebPage page : webPageList) {
                System.out.println(page.getTitle());
            }
        } else {
            System.out.println("not found");
        }
        System.out.println();
    }
}
