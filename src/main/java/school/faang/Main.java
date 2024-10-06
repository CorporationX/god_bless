package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webMap = new HashMap<>();
    public static void main(String[] args) {

        WebPage wikiPage = new WebPage("https://ru.wikipedia.org/wiki/home_page",
                "Home_page", "Добро пожаловать в Википедию");

        WebPage youTubePage = new WebPage("https://www.youtube.com/playlist?list=WL",
                "playlist",
                "Одно или несколько видео удалены из плейлиста");
        indexWeb(wikiPage);
        for(Map.Entry<String,List<WebPage>> entry : webMap.entrySet()){
            System.out.println("Кодовое слово: " + entry.getKey() +
                                "Название страницы: " + entry.getValue());
        }

        indexWeb(youTubePage);

        for(Map.Entry<String,List<WebPage>> entry : webMap.entrySet()){
            System.out.println("Кодовое слово: " + entry.getKey() +
                    "Название страницы: " + entry.getValue());
        }
    }

    public static void indexWeb(WebPage webPage) {
        String content = webPage.getContent();
        List<String> words = Arrays.asList(content.split("\\W+"));
        for (String word : words) {
            List<WebPage> webPages = webMap.get(word);
            if (webPages!= null) {
                webMap.get(word).add(webPage);
            } else {
                webPages = new ArrayList<>();
                webPages.add(webPage);
                webMap.put(word, webPages);
            }
        }
    }

}
