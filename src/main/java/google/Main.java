package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<String, List<WebPage>> WEB_PAGES_MAP = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("google.com", "Search", "I will find everything");
        WebPage webPage2 = new WebPage("yandex.ru", "Search", "I will find everything");
        WebPage webPage3 = new WebPage("bookbuy.com", "Book shop", "Buy books online");
        WebPage webPage4 = new WebPage("readbook.com", "Read book", "Read books online");
        WebPage webPage5 = new WebPage("delete.com", "delete", "Buy books online");


        indexWebPage(webPage1);
        indexWebPage(webPage2);
        indexWebPage(webPage3);
        indexWebPage(webPage4);
        indexWebPage(webPage5);

        System.out.println("================================");
        printWebPages(findByKeyWord("books"));
        System.out.println("================================");
        printWebPages(findByKeyWord("find"));
        System.out.println("================================");
        printWebPages(findByKeyWord("Buy"));
        System.out.println("================================");

        deleteWebPageByUrl("delete.com");

        System.out.println("\nAfter removal:\n");
        printWebPages(findByKeyWord("books"));
    }

    public static void indexWebPage(WebPage webPage) {
        for (String keyWord : webPage.getContent().split(" ")) {
            if (!WEB_PAGES_MAP.containsKey(keyWord)) {
                WEB_PAGES_MAP.put(keyWord, new ArrayList<>());
            }
            WEB_PAGES_MAP.get(keyWord).add(webPage);
        }
    }

    public static List<WebPage> findByKeyWord(String keyWord) {
        if (!WEB_PAGES_MAP.containsKey(keyWord)) {
            throw new NullPointerException("По запросу " + keyWord + " страниц не найдено");
        }
        return WEB_PAGES_MAP.get(keyWord);
    }

    public static void deleteWebPageByUrl(String url) {
        List<String> keyWords = new ArrayList<>();
        WebPage webPageForRemove = null;
        for (Map.Entry<String, List<WebPage>> entry : WEB_PAGES_MAP.entrySet()) {
            List<WebPage> webPages = entry.getValue();
            for (WebPage webPage : webPages) {
                if (webPage.getUrl().equals(url)) {
                    keyWords = List.of(webPage.getContent().split(" "));
                    webPageForRemove = webPage;
                    break;
                }
            }
            if (!keyWords.isEmpty()) {
                break;
            }
        }
        for (String keyWord : keyWords) {
            WEB_PAGES_MAP.get(keyWord).remove(webPageForRemove);
        }
    }

    public static void printWebPages(List<WebPage> webPages) {
        for (WebPage webPage : webPages) {
            System.out.println("URL: " + webPage.getUrl() + " | Title: " + webPage.getTitle());
        }
    }
}
