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
        System.out.println(findWebPagesByKeyword("This"));
        System.out.println(findWebPagesByKeyword("notexist"));

    }

    public static void splitUrl(WebPage page){
        Arrays.asList(page.content().split("\\W+")).forEach(word -> {
            PAGES.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        });
    }

    public static List<WebPage> findWebPagesByKeyword(String keyword){
        List<WebPage> webPages = new ArrayList<>();

        Optional.ofNullable(PAGES.get(keyword)).ifPresent(webPages::addAll);

        return webPages;
    }
}
