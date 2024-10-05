package school.faang.search_google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Map<String, List<WebPage>> keyWordList = new HashMap<>();
    private static final Map<String, Set<String>> URL_TO_WORDS = new HashMap<>();


    public static void main(String[] args) {
        WebPage webPage = new WebPage("httos://frik.com", "True my god",
                "Hello my, my My name is my Maksim. I go i to work. I need, help!");
        WebPage webPageTwo = new WebPage("httos://stepi.com", "No your dog",
                " to Java classes. It can be used as a Java agen");
        pageIndexing(webPage);
        pageIndexing(webPageTwo);
        for (Map.Entry<String, List<WebPage>> entry : keyWordList.entrySet()) {
            System.out.println(entry.getKey() + "=  " + entry.getValue());
        }
        System.out.println("--------------");
//        removeWebPageFromList("i");
        for (Map.Entry<String, List<WebPage>> entry : keyWordList.entrySet()) {
            System.out.println(entry.getKey() + "=  " + entry.getValue());
        }
    }

    public static void pageIndexing(WebPage webPage) {
        String data = webPage.content().trim();
        Set<String> wordArray = new HashSet<>(List.of(data.split("\\PL")));
        
    }

    public static List<WebPage> getListWebPageOnWordKey(String keyWord) {
        return keyWordList.get(keyWord);
    }

    public static void removeWebPageFromList(String urlKey) {
        for (Map.Entry<String, List<WebPage>> entry : keyWordList.entrySet()) {
            List<WebPage> listWebPage = entry.getValue();
        }
    }
}
