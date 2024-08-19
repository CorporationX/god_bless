package BJS2_20213;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<WebPage>> INDEXED_PAGES = new HashMap<>();
    private static final Set<WebPage> PAGES = new HashSet<>();

    public static void main(String[] args) {

        //Add webpage indexes into hashMap and pageSet (
        addIndexes(new WebPage("yandex.ru", "Yandex", "music market fun"));
        addIndexes(new WebPage("google.com", "Google", "bigTech account search"));
        addIndexes(new WebPage("youtube.ru", "Youtube", "music stream videos"));
        addIndexes(new WebPage("spotify.com", "Spotify", "fun music chill"));

        //Null passed as parameter
        addIndexes(null);

        //Search by keyWord
        System.out.println(findWebPages("chill"));

        //remove by url
        removeWebPageByUrl("youtube.ru");

    }

    public static void addIndexes(WebPage webPage) {
        if (webPage != null) {
            if (!PAGES.contains(webPage)) {
                PAGES.add(webPage);
                String[] words = webPage.getContent().split(" ");
                for (String word : words) {
                    INDEXED_PAGES.computeIfAbsent(word, key -> new ArrayList<>()).add(webPage);
                }
            }
        }
        else {
            System.out.println("Web page can't be null!");
        }
    }

    public static List<WebPage> findWebPages(String keyWord) {
        return new ArrayList<>(INDEXED_PAGES.getOrDefault(keyWord, INDEXED_PAGES.get(keyWord)));
    }

    public static void removeWebPageByUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : INDEXED_PAGES.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
