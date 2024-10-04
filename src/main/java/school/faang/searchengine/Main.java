package school.faang.searchengine;

import school.faang.searchengine.classes.WebPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, List<WebPage>> webPagesMap = new HashMap<>();

    public static void indexingNewWebPage(WebPage webPage) {
        for(String word : webPage.getContent().split(" ")) {
            webPagesMap.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPageByWord(String word) {
        return webPagesMap.get(word);
    }

    public static void deleteWebPage(String url) {
        for(List<WebPage> webPageList : webPagesMap.values()) {
            webPageList.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }

    public static void main(String[] args) {
        indexingNewWebPage(new WebPage("lenta.ru", "lenta", "all the latest news"));
        indexingNewWebPage(new WebPage("mail.ru", "mail", "mail and news"));
        indexingNewWebPage(new WebPage("drom.ru", "drom", "news about cars"));

        for(Map.Entry<String, List<WebPage>> entry : webPagesMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        deleteWebPage("mail.ru");

        System.out.println(findWebPageByWord("news"));

        for(Map.Entry<String, List<WebPage>> entry : webPagesMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}