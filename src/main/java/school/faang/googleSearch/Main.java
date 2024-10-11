package school.faang.googleSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashMap<String, List<WebPage>> similarPages = new HashMap<>();

    public static void indexPages(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split("\\s+");
        for (String word : words) {
            similarPages.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPagesBySimilarities(String keyWord) {
        if (similarPages.containsKey(keyWord)) {
            return similarPages.get(keyWord);
        } else {
            throw new IllegalArgumentException("There is no any web page");
        }
    }

    public static void deleteWebPageByUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : similarPages.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("google.com", "Java", "IT startups");
        WebPage webPage2 = new WebPage("yandex.ru", "Go", "IT Hello world");
        WebPage webPage3 = new WebPage("threads.com", "Python", "Top food in Istanbul");
        WebPage webPage4 = new WebPage("instagram.com", "JavaScript", "gambling is good for your " +
                "financial state");
        WebPage webPage5 = new WebPage("blog.com", "PHP", "kazakh food is underrated");

        indexPages(webPage1);
        indexPages(webPage2);
        indexPages(webPage3);
        indexPages(webPage4);
        indexPages(webPage5);
        System.out.println(similarPages);
        System.out.println();

        System.out.println(findWebPagesBySimilarities("is"));
        System.out.println();

        deleteWebPageByUrl("yandex.ru");
        System.out.println(similarPages);

    }
}
