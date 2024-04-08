package aboutgoogle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webPagesByKeywords = new HashMap<>();

    public static void main(String[] args) {
        String content1 = "Collection.removeIf(Predicate<? super E> filter).";
        String content2 = "Map.computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)";

        WebPage page1 = new WebPage("http://test1.page", "Something important thing", content1);
        WebPage page2 = new WebPage("http://test2.page", "More important thing", content2);

        addToIndex(page1);
        addToIndex(page2);

        getListOfPagesByKeyWord("filter").forEach(System.out::println);
        removeWebPage("http://test2.page");
        getListOfPagesByKeyWord("key").forEach(System.out::println);
    }

    private static void addToIndex(WebPage webPage) {
        String[] words = webPage.getContent().split(" ");
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            word = word.toLowerCase();
            if (!word.equals("the") && word.length() > 1) {
                webPagesByKeywords.computeIfAbsent(word, key -> new ArrayList<>()).add(webPage);
            }
        }
    }

    private static List<WebPage> getListOfPagesByKeyWord(String keyWord) {
        return webPagesByKeywords.get(keyWord.toLowerCase());
    }

    private static void removeWebPage(String url) {
        webPagesByKeywords.values().forEach(elem -> elem.removeIf(page -> page.getUrl().equals(url)));
    }
}
