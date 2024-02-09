package faang.school.godbless.hash_map.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> mapWebPage = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("vk.com", "Новости", "Россия СШA Китай");
        WebPage webPage2 = new WebPage("kulinariya.ru", "Рецепты", "Солянка Борщ");
        WebPage webPage3 = new WebPage("youtube.com", "Видео", "Солянка Россия Китай");
        WebPage webPage4 = new WebPage("kulinariya.ru", "Рецепты", "Торт Картошка");

        add(webPage1);
        add(webPage2);
        add(webPage3);
        add(webPage4);
        System.out.println(mapWebPage);

        System.out.println(findWordInPage("Солянка"));

        deletePage("kulinariya.ru");

        System.out.println(mapWebPage);
    }

    public static void add(WebPage webPage) {
        String[] words = webPage.getContent().split(" ");
        for(String word: words){
            if(!mapWebPage.containsKey(word)){
                mapWebPage.put(word, new ArrayList<>());
            }
            mapWebPage.get(word).add(webPage);
        }
    }

    public static List<WebPage> findWordInPage(String word){
        return mapWebPage.get(word);
    }

    public static void deletePage(String url){
        for (List<WebPage> listWebPage : mapWebPage.values()){
            listWebPage.removeIf(webPage -> webPage.getUrl().equals(url));
        }

    }
}
