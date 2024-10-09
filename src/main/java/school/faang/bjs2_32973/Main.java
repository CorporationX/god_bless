package school.faang.bjs2_32973;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<WebPage>> indexMap = new HashMap<>();
        testIndexWebPage(indexMap);
        testGetWebPagesByWord(indexMap);
        testRemoveFromIndexByUrl(indexMap);


    }

    private static void testIndexWebPage(Map<String, List<WebPage>> webPageKeywordIndex) {
        System.out.println("\ntestIndexWebPage\n");
        WebPageIndexer webPageIndexer = new WebPageIndexer();
        WebPage webPage1 = new WebPage("https://test.com", "Test Page", "Test $#content.");
        WebPage webPage2 = new WebPage("https://openai.com", "OpenAI Page", "test CONTENT% run");

        System.out.println("index before:");
        printIndex(webPageKeywordIndex);

        webPageIndexer.indexWebPage(webPage1, webPageKeywordIndex);
        webPageIndexer.indexWebPage(webPage2, webPageKeywordIndex);

        System.out.println("\nadd:");
        System.out.println(webPage1);
        System.out.println(webPage2);

        System.out.println("\nindex after:");
        printIndex(webPageKeywordIndex);
    }

    private static void testGetWebPagesByWord(Map<String, List<WebPage>> webPageKeywordIndex) {
        WebPageIndexer webPageIndexer = new WebPageIndexer();
        System.out.println("\ntestGetWebPagesByWord\n");
        String keyWord = "TEST";
        System.out.println("list web pages by word - " + keyWord);
        List<WebPage> webPagesByWord = webPageIndexer.getWebPagesByWord(keyWord, webPageKeywordIndex);
        for (WebPage webPage : webPagesByWord) {
            System.out.println(webPage);
        }


    }

    private static void testRemoveFromIndexByUrl(Map<String, List<WebPage>> indexMap) {
        System.out.println("\ntestRemoveFromIndexByUrl\n");

        WebPageIndexer webPageIndexer = new WebPageIndexer();
        String urlForRemove = "https://openai.com";

        System.out.println("indexMap before:");
        printIndex(indexMap);

        webPageIndexer.removeFromIndexByUrl(urlForRemove, indexMap);
        System.out.println("delete by URL - https://openai.com");

        System.out.println("\nindexMap after:");
        printIndex(indexMap);
    }

    private static void printIndex(Map<String, List<WebPage>> indexMap) {
        for (Map.Entry<String, List<WebPage>> stringListEntry : indexMap.entrySet()) {
            System.out.println(stringListEntry.getKey());
            List<WebPage> webPages = stringListEntry.getValue();
            for (WebPage webPage : webPages) {
                System.out.println(webPage);
            }
            System.out.println();
        }
    }
}
