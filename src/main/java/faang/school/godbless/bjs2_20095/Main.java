package faang.school.godbless.bjs2_20095;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

public class Main {
    private static final String SPLITTING_PATTERN = "[\\W_]+"; // only letters or digits
    private static Map<String, List<WebPage>> index;
    private static Map<String, Set<String>> urlWithContent = new HashMap<String, Set<String>>();


    public static void main(String[] args) {
        index = new HashMap<>();
        urlWithContent = new HashMap<>();

        var webPage1 = new WebPage("url1", "title1", "hello world");
        addWebPageToIndex(webPage1);
        var webPage2 = new WebPage("url2", "title2", "hello world google");
        addWebPageToIndex(webPage2);
        var webPage3 = new WebPage("url3", "title3", "hello google unique");
        addWebPageToIndex(webPage3);
        printData();

        var searchResult1 = getWebPagesByWord("hello");
        printPages(searchResult1);
        System.out.println("-");
        var searchResult2 = getWebPagesByWord("world");
        printPages(searchResult2);
        System.out.println("-");
        var searchResult3 = getWebPagesByWord("google");
        printPages(searchResult3);
        System.out.println("-");
        var searchResult4 = getWebPagesByWord("unique");
        printPages(searchResult4);
        System.out.println("--------------------");

        removeWebPageByUrl("url2");
        printData();
    }

    private static void addWebPageToIndex(WebPage webPage) {
        var content = webPage.getContent();
        String[] words = content.split(SPLITTING_PATTERN);
        Set<String> uniqueWords = new HashSet<>(asList(words));
        for (String word : uniqueWords) {
            index.computeIfAbsent(word, wb -> new ArrayList<>()).add(webPage);
        }
        urlWithContent.put(webPage.getUrl(), uniqueWords);
    }

    private static List<WebPage> getWebPagesByWord(String word) {
        return index.get(word); // add: return if contains, part of word
    }

    private static void removeWebPageByUrl(String url) {
        var words = urlWithContent.get(url);
        for (String word : words) {
            index.get(word).remove(new WebPage(url));
        }
    }

    private static void printData() {
        for (Map.Entry<String, List<WebPage>> entry : index.entrySet()) {
            System.out.println("Word: " + entry.getKey());
            printPages(entry.getValue());
        }
        System.out.println("--------------------");
    }

    private static void printPages(List<WebPage> pages) {
        pages.forEach(p -> System.out.println("    " + p.getUrl()));
    }
}
