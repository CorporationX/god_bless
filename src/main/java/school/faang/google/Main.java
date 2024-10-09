package school.faang.google;

import java.util.*;

public class Main {
    static Map<String, List<WebPage>> indexWebPagesMap = new HashMap<>();
    static Map<String, WebPage> urlMap = new HashMap<>();

    public static void main(String[] args) {

        addWebPageToIndex(new WebPage("travel.ru", "travel", "Hello Mr"));
        addWebPageToIndex(new WebPage("travel.ru", "travel", "Hello Mr"));
        addWebPageToIndex(new WebPage("google.com", "test", "Hello World"));
        addWebPageToIndex(new WebPage("instagram.ru", "test", "Hello Again"));
        deleteIndexByUrl("travel.ru");
        deleteIndexByUrl("instagram.ru");
    }

    public static void addWebPageToIndex(WebPage webPage) {

        String[] contentList = webPage.getContent().split("\\s");

        for (String word : contentList) {
            List<WebPage> indexedWebPages = indexWebPagesMap.computeIfAbsent(word, x -> new LinkedList<WebPage>());

            if (!indexedWebPages.contains(webPage)) {
                indexedWebPages.add(webPage);

                urlMap.computeIfAbsent(webPage.getUrl(), x -> new WebPage(webPage.getUrl(), webPage.getTitle(),webPage.getContent()));
            }
        }
    }

    public static List<WebPage> searchByIndex(String index) {
        return indexWebPagesMap.get(index);
    }

    public static void deleteIndexByUrl(String url) {
        WebPage toDeleteWP = urlMap.get(url);
        String[] toDeleteWordsContent = toDeleteWP.getContent().split("\\s");

        for (String word : toDeleteWordsContent) {
            if (indexWebPagesMap.get(word).contains(toDeleteWP)) {
                indexWebPagesMap.get(word).remove(toDeleteWP);
            }
        }
        urlMap.remove(url);
    }
}