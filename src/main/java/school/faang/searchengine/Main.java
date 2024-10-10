package school.faang.searchengine;

import school.faang.searchengine.classes.WebPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, List<WebPage>> webPages = new HashMap<>();

    public static void indexWebPage(WebPage webPage) {
        for(String word : webPage.getContent().toLowerCase().split("[\\s.,:;?!-]+")) { //Убрать знаки припинания
            webPages.computeIfAbsent(word.toLowerCase(), k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPageByWord(String word) {
        return webPages.get(word);
    }

    public static void deleteWebPageByUrl(String url) {
        List<String> keysToRemove = new ArrayList<>();

        for(Map.Entry<String, List<WebPage>> entry : webPages.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
            if(entry.getValue().isEmpty()) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (String key : keysToRemove) {
            webPages.remove(key);
        }
    }

    public static void main(String[] args) {
        indexWebPage(new WebPage("lenta.ru", "lenta", "lenta, all the latest NEWS"));
        indexWebPage(new WebPage("mail.ru", "mail", "mail and news"));
        indexWebPage(new WebPage("drom.ru", "drom", "news  about cars"));

        for(Map.Entry<String, List<WebPage>> entry : webPages.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        deleteWebPageByUrl("mail.ru");

        System.out.println(findWebPageByWord("news"));

        for(Map.Entry<String, List<WebPage>> entry : webPages.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}