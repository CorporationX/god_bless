package faang.school.godbless.BJS_20060;

import java.util.*;

public class Main {
    private static Map<String, List<WebPage>> indexes = new HashMap<>();

    public static void main(String[] args) {
        WebPage google = new WebPage("google.com/greetings", "Google", "This is google greeting page");
        WebPage yandex = new WebPage("yandex.ru/greetings/ru", "Yandex", "This is yandex greeting page for ru users");
        WebPage instagram = new WebPage("instagram.com/photo", "Insta", "This is for your photos");

        indexUrl(google);
        indexUrl(yandex);
        indexUrl(instagram);
        System.out.println(indexes);
        System.out.println(findWebPagesByKeyword("This"));
        System.out.println(findWebPagesByKeyword("notexist"));

    }

    public static void indexUrl(WebPage page){
        Arrays.asList(page.content().split("\\W+")).forEach(word -> {
            indexes.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        });
    }

    public static List<WebPage> findWebPagesByKeyword(String keyword){
        return Optional.ofNullable(indexes.get(keyword)).orElseThrow(() -> new IllegalArgumentException("Incorrect index"));
    }
}
