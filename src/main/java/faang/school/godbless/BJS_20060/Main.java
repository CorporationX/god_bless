package faang.school.godbless.BJS_20060;

import java.util.*;

public class Main {
    private static final Map<String, List<WebPage>> PAGES = new HashMap<>();

    public static void main(String[] args) {
        WebPage google = new WebPage("google.com/greetings", "Google", "This is google greeting page");
        WebPage yandex = new WebPage("yandex.ru/greetings/ru", "Yandex", "This is yandex greeting page for ru users");
        WebPage instagram = new WebPage("instagram.com/photo", "Insta", "This is for your photos");

        splitUrl(google);
        splitUrl(yandex);
        splitUrl(instagram);
        System.out.println(PAGES);
        findWebPagesByKeyword("This");
        findWebPagesByKeyword("notexist");

    }

    public static void splitUrl(WebPage page){
        Arrays.asList(page.content().split("\\W+")).forEach(word -> {
            PAGES.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        });
    }

    public static void findWebPagesByKeyword(String keyword){
        Optional.ofNullable(PAGES.get(keyword)).ifPresent(list -> list.forEach(webPage -> System.out.println(webPage.url())));
    }
}
