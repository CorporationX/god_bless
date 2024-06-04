package faang.school.godbless.search;

import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<WebPage> webPages = createWebPages();
        SearchEngine searchEngine = new SearchEngine(new HashMap<>());
        searchEngine.indexWebPage(webPages.get(0));
        searchEngine.indexWebPage(webPages.get(1));
        searchEngine.indexWebPage(webPages.get(2));
        searchEngine.indexWebPage(webPages.get(3));

        System.out.println("================================");
        System.out.println("Indexing all web pages");
        System.out.println("================================");
        searchEngine.getWebPagesByKeyword().forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("================================");
        System.out.println("Searching for a list of web pages that contain information on HashMaps");
        System.out.println("================================");
        List<WebPage> webPagesContainingKeyword = searchEngine.searchWebPages("HashMaps");
        System.out.println(webPagesContainingKeyword);

        searchEngine.deleteWebPage("javarush.ru");

        System.out.println("================================");
        System.out.println("Check web pages after javarush removal");
        System.out.println("================================");
        List<WebPage> webPagesAfterRemoval = searchEngine.searchWebPages("HashMaps");
        System.out.println(webPagesAfterRemoval);

    }

    private static List<WebPage> createWebPages() {
        return List.of(
                new WebPage("faang.school", "HashMaps are good!", "HashMaps prove to be the best data structure" +
                        " for associated array of data"),
                new WebPage("faang.school", "HashMaps are good!", null),
                new WebPage("javarush.ru", "Hashmaps are so bad! Do not listen to anyone",
                        "HashMaps are overrated! You should stick to the basics and use HashTables"),
                new WebPage("baeldung.com", "Hashmaps FTW", "If you have no idea what to use, use HashMaps")
        );
    }
}
