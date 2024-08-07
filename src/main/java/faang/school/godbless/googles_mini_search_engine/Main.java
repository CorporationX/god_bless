package faang.school.godbless.googles_mini_search_engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, List<WebPage>> dictionaryOfWebPages = new HashMap<>();

    public static void main(String[] args) {
        WebPage googleWebPage = new WebPage(
                "https://www.google.com",
                "Google",
                "Google is a search engine"
        );

        WebPage yahooWebPage = new WebPage(
                "https://www.yahoo.com",
                "Yahoo",
                "Yahoo is a search engine"
        );

        WebPage loremIpsumWebPage = new WebPage(
                "https://www.loremipsum.com",
                "Lorem Ipsum",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has " +
                        "been the industry's standard dummy text ever since the 1500s, when an unknown printer took " +
                        "a galley of type and scrambled it to make a type specimen book. It has survived not only " +
                        "five centuries, but also the leap into electronic typesetting, remaining essentially " +
                        "unchanged. It was popularised in the 1960s with the release of Letraset sheets containing " +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus " +
                        "PageMaker including versions of Lorem Ipsum."
        );

        indexPage(googleWebPage);
        indexPage(yahooWebPage);
        indexPage(loremIpsumWebPage);

        System.out.println(search("Google"));;

        removePage("https://www.yahoo.com");
        System.out.println(search("Yahoo"));;
    }

    public static void indexPage(WebPage webPage) {
        String content = webPage.getContent();
        List<String> words = List.of(content.split(" "));

        for (String word : words) {
            dictionaryOfWebPages.computeIfAbsent(word.toLowerCase(), k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> search(String query) {
        return dictionaryOfWebPages.getOrDefault(query.toLowerCase(), List.of());
    }

    public static void removePage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : dictionaryOfWebPages.entrySet()) {
            for (WebPage page : entry.getValue()) {
                if (page.getUrl().equals(url)) {
                    entry.getValue().remove(page);
                    break;
                }
            }
        }
    }
}
