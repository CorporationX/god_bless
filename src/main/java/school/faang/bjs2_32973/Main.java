package school.faang.bjs2_32973;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<WebPage>> webPageKeywordIndex  = new HashMap<>();
        WebPage page1 = new WebPage("https://example.com", "Example Page", "this this this this");
//        WebPage page2 = new WebPage("https://test.com", "Test Page", "Test the indexing method with this content.");
//        WebPage page3 = new WebPage("https://java.com", "Java Page", "Learn Java and its features through examples.");
//        WebPage page4 = new WebPage("https://openai.com", "OpenAI Page", "Explore AI development with OpenAI's tools.");
//        WebPage page5 = new WebPage("https://blog.com", "Blog Page", "Welcome to the blog. This is the first post.");
//        WebPage page6 = new WebPage("https://blog.com", "Blog Page", "Blog");
//        WebPage page7 = new WebPage("https://blog.com", "Blog Page", "Blog");
//        WebPage page8 = new WebPage("https://blog.com", "Blog Page", "Blog");
//        WebPage page9 = new WebPage("https://blog.com", "Blog Page", "Blog");
//        WebPage page10 = new WebPage("https://blog.com", "Blog Page", "Blog");

        // Создаем карту для хранения индекса (ключ - слово, значение - список WebPage)
        Map<String, List<WebPage>> indexMap = new HashMap<>();

        // Тестируем метод индексирования (например, indexWebPage(page1, indexMap))
        WebPageIndexer webPageIndexer = new WebPageIndexer();
        webPageIndexer.indexWebPage(page1, indexMap);
//        webPageIndexer.indexWebPage(page2, indexMap);
//        webPageIndexer.indexWebPage(page3, indexMap);
//        webPageIndexer.indexWebPage(page4, indexMap);
//        webPageIndexer.indexWebPage(page5, indexMap);
//        webPageIndexer.indexWebPage(page6, indexMap);
//        webPageIndexer.indexWebPage(page7, indexMap);
//        webPageIndexer.indexWebPage(page8, indexMap);
//        webPageIndexer.indexWebPage(page9, indexMap);
//        webPageIndexer.indexWebPage(page10, indexMap);
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
