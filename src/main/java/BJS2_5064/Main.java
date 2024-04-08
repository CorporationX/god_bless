package BJS2_5064;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collection;
public class Main {
    private static final Map<String, List<WebPage>> WORD_IN_URL = new HashMap<>();

    public static void main(String[] args) {
        addNewWebPage(new WebPage("yandex.ru", "Яндекс", "music,travel,marketplace,video"));
        addNewWebPage(new WebPage("raider.io", "World of Warcraft Rankings", "wow,rio,m+,route"));
        addNewWebPage(new WebPage("twitch.tv", "Twitch", "stream,game,streamer,channel"));
        addNewWebPage(new WebPage("youtube.com", "Youtube", "stream,game,channel,short,video"));

        //System.out.println(findWebPages("game"));
        removePage("twitch.tv");
        removePage("raider.io");
        removePage("youtube.com");
        removePage("yandex.ru");

        System.out.println(findWebPages("video"));
    }

    private static void addNewWebPage(WebPage webPage) {
        for (String word : webPage.getContent().split(",")) {
            WORD_IN_URL.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    private static List<WebPage> findWebPages(String content) {
        return WORD_IN_URL.get(content);
    }

    private static void removePage(String url) {
        WORD_IN_URL.values().forEach(k -> k.removeIf(v -> v.getUrl().equals(url)));
    }
}
