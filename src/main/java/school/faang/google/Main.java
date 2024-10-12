package school.faang.google;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    static Map<String, List<WebPage>> indexWebPages = new HashMap<>();

    public static void main(String[] args) {

        addWebPageToIndex(new WebPage("travel.ru", "travel", "Hello Mr"));
        addWebPageToIndex(new WebPage("travel.ru", "travel", "Hello Mr"));
        addWebPageToIndex(new WebPage("google.com", "test", "Hello World"));
        addWebPageToIndex(new WebPage("instagram.ru", "test", "Hello Again"));
        delete("travel.ru");
        delete("instagram.ru");
    }

    public static void addWebPageToIndex(WebPage webPage) {

        String[] contentList = webPage.content().split("\\s");

        for (String word : contentList) {
            List<WebPage> indexedWebPages = indexWebPages.computeIfAbsent(word.toLowerCase(), x -> new LinkedList<WebPage>());

            if (!indexedWebPages.contains(webPage)) {
                indexedWebPages.add(webPage);
            }
        }
    }

    public static List<WebPage> search(String index) {
        return indexWebPages.get(index.toLowerCase());
    }

    public static void delete(String url) {
        Predicate<WebPage> condition = web -> web.url().contains(url);

        for (Map.Entry<String, List<WebPage>> entry : indexWebPages.entrySet()) {
            entry.getValue().removeIf(condition);
        }
    }

}
