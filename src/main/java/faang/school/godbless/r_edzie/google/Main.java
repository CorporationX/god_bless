package faang.school.godbless.r_edzie.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webPages = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("google.com", "Google", "Google is most popular browser search");
        WebPage webPage2 = new WebPage("ya.ru", "Yandex", "Yandex is russian browser search");
        WebPage webPage3 = new WebPage("vk.com", "VK", "Vk is russian social network");
        WebPage webPage4 = new WebPage("youtube.com", "YouTube", "YouTube is video hosting");

        indexWebPage(webPage1);
        indexWebPage(webPage2);
        indexWebPage(webPage3);
        indexWebPage(webPage4);

        searchByKeyword("russian").forEach(System.out::println);

        removeByUrl("vk.com");

        System.out.println(webPages);
    }

    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split(" ");

        for (String word : words) {
            webPages.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> searchByKeyword(String keyword) {
        List<WebPage> pages = webPages.get(keyword);
        return pages.isEmpty() ? new ArrayList<>() : pages;
    }

    public static void removeByUrl(String url) {
        for (List<WebPage> webPageList : webPages.values()) {
            webPageList.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
