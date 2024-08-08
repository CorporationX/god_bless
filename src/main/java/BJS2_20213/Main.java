package BJS2_20213;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, List<WebPage>> index = new HashMap<>();
    private static Set<WebPage> pageSet = new HashSet<>();

    public static void main(String[] args) {

        //Add webpage indexes into hashMap and pageSet (
        addIndexes(new WebPage("yandex.ru", "Yandex", "music market fun"));
        addIndexes(new WebPage("google.com", "Google", "bigTech account search"));
        addIndexes(new WebPage("youtube.ru", "Youtube", "music stream videos"));
        addIndexes(new WebPage("spotify.com", "Spotify", "fun music chill"));

        //Search by keyWord
        System.out.println(findWebPages("chill"));

        //remove by url
        removeWebPageByUrl("youtube.ru");

    }

    public static void addIndexes(WebPage webPage) {
        if (!pageSet.contains(webPage)) {
            pageSet.add(webPage);
            String[] words = webPage.getContent().split(" ");
            for (String word : words) {
                index.computeIfAbsent(word, key -> new ArrayList<>()).add(webPage);
            }
        }
    }

    public static List<WebPage> findWebPages(String keyWord) {
        List<WebPage> resultList = new ArrayList<>();

        for (Map.Entry<String, List<WebPage>> entry : index.entrySet()) {
            if (entry.getKey().equals(keyWord)) {
                resultList.addAll(entry.getValue());
            }
        }
        return resultList;
    }

    public static void removeWebPageByUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : index.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
