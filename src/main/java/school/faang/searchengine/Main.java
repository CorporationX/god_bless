package school.faang.searchengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    public static Map<String, List<WebPage>> webPagesOfKeyWords = new HashMap<>();
    public static Map<String, Set<String>> keyWordsPerUrl = new HashMap<>();

    public static void main(String[] args) {
        WebPage page1 = new WebPage("https://test-page1.com", "Title1", "This is an test-page1 content.");
        WebPage page2 = new WebPage("https://test-page2.com", "Title2", "This is another page content. Some new words here.");
        WebPage page3 = new WebPage("https://test-page3.com", "Title3", "This is a new PAGE with New Content. Very interesting info.");

        indexWebPage(page1);
        indexWebPage(page2);
        indexWebPage(page3);
        printMap(webPagesOfKeyWords);

        System.out.println("\nFind web pages by key word");
        findWebPageByKeyWord("interesting");
        findWebPageByKeyWord("THIS");
        findWebPageByKeyWord("TEST-not-found");

        removePageByUrl("https://test-page3.com");
        printMap(webPagesOfKeyWords);
    }

    //    метод для индексирования новой веб-страницы
    public static void indexWebPage(WebPage page) {
        Set<String> words = parseContent(page);
        for (String word : words) {
            webPagesOfKeyWords.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
        keyWordsPerUrl.put(page.getUrl(), words);
    }

    //    метод для удаления веб-страницы из индекса по её URL
    public static void removePageByUrl(String url) {
        Set<String> words = keyWordsPerUrl.get(url);
        for (String word : words) {
            webPagesOfKeyWords.get(word).removeIf(webPage -> webPage.getUrl().equals(url));
            if (webPagesOfKeyWords.get(word).isEmpty()) {
                webPagesOfKeyWords.remove(word);
            }
        }
        words.remove(url);
    }

    //    метод поиска веб-страниц по ключевому слову, который будет принимать строку (ключевое слово) и возвращать список веб-страниц, содержащих это ключевое слово
    public static List<WebPage> findWebPageByKeyWord(String keyWord) {
        List<WebPage> webPages = webPagesOfKeyWords.get(keyWord.toLowerCase());
        if (webPages != null && !webPages.isEmpty()) {
            System.out.println("Web pages for key word " + keyWord + ": " + webPages);
        } else {
            System.out.println("List of web pages is either null or empty");
        }
        return webPages;
    }

    private static Set<String> parseContent(WebPage page) {
        String cleanedText = page.getContent().toLowerCase().replaceAll("[^a-zA-Z]", " ");
        return new HashSet<>(Arrays.asList(cleanedText.split("\\s+")));
    }

    private static void printMap(Map<String, List<WebPage>> keyWords) {
        for (String key : keyWords.keySet())
            System.out.printf("| %-20s | %-200s \n", key, keyWords.get(key));
    }
}
