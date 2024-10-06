package school.faang.HashMaps.miniGoogleEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> index = new HashMap<>();

    public static void main(String[] args) {
        index(new WebPage("faang.com", "faang", "Вы решили создать простой поисковой движок"));
        index(new WebPage("yandex.ru", "yandex", "какой-то текст"));
        index(new WebPage("dzen.ru", "dzen", "Вы решили"));
        deletePageFromIndex("dzen.ru");
        System.out.println(index);
        System.out.println(searchPages("Вы"));
    }

    public static void index(WebPage webPage) {
        List<String> words = Arrays.stream(webPage.getContent().trim().split(" ")).toList();
        words.forEach(word -> index.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage));
    }

    public static List<WebPage> searchPages(String word) {
        return index.get(word);
    }

    public static void deletePageFromIndex(String url) {
        index.forEach((k, v) -> v.removeIf(x -> x.getUrl().equals(url)));
    }
}
