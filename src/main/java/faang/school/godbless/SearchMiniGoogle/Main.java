package faang.school.godbless.SearchMiniGoogle;

import java.util.*;

public class Main {

    private static final Map<String, List<WebPage>> PAGES_BY_KEYWORD = new HashMap<>();

    public static void main(String[] args) {
        WebPage dotaPage = new WebPage("dota", "dota.com", "dota pudge");
        WebPage mosruPage = new WebPage("mosru", "mosru.ru", "service");
        WebPage dotabuffPage = new WebPage("dotabuff", "dotabuff.com", "pudge");
        WebPage funpayPage = new WebPage("funpay", "funpay.com", "service dota");

        indexPage(dotaPage);
        indexPage(mosruPage);
        indexPage(dotabuffPage);
        indexPage(funpayPage);

        searchPagesByKeyWord("dota");
        searchPagesByKeyWord("pudge");
        searchPagesByKeyWord("service");

        System.out.println("\n");

        searchPagesByKeyWord("msru.ru");

        deletePageByUrl("dota.com");
        deletePageByUrl("dфыв");

        searchPagesByKeyWord("dota");

        printAllIndexesAndPages();

    }

    private static void indexPage(WebPage page) {
        StringTokenizer stringTokenizer = new StringTokenizer(page.getContent(), " ");

        while (stringTokenizer.hasMoreElements()) {
            String key = stringTokenizer.nextToken();
            PAGES_BY_KEYWORD.putIfAbsent(key, new ArrayList<>());
            PAGES_BY_KEYWORD.get(key).add(page);
        }
        PAGES_BY_KEYWORD.putIfAbsent(page.getUrl(), new ArrayList<>());
        PAGES_BY_KEYWORD.get(page.getUrl()).add(page);
    }

    private static void searchPagesByKeyWord(String keyword) {
        System.out.println("ЗА ЗАПРОСУ " + keyword + " НАЙДЕНО:");
        if (PAGES_BY_KEYWORD.get(keyword) == null) {
            System.out.println("НИЧЕГО");
        }
        else {
            PAGES_BY_KEYWORD.get(keyword).forEach(webpage -> System.out.println(webpage.getTitle()));
        }
    }

    private static void deletePageByUrl(String url) {
        if (!PAGES_BY_KEYWORD.containsKey(url)) return;
        WebPage pageToDelete = PAGES_BY_KEYWORD.get(url).get(0);

        StringTokenizer stringTokenizer = new StringTokenizer(pageToDelete.getContent(), " ");

        List<String> keyWordsToDelete = new ArrayList<>();

        while (stringTokenizer.hasMoreElements()) {
            String key = stringTokenizer.nextToken();
            keyWordsToDelete.add(key);
        }
        PAGES_BY_KEYWORD.remove(url);

        keyWordsToDelete.forEach(keyWordToDelete -> PAGES_BY_KEYWORD.get(keyWordToDelete).remove(pageToDelete));
    }

    private static void printAllIndexesAndPages() {
        PAGES_BY_KEYWORD.forEach((word, page) -> {
            System.out.println(word);
            PAGES_BY_KEYWORD.get(word).forEach(webPage -> System.out.println(webPage.getTitle()));
            System.out.println("________________________________");
        });

    }
}
