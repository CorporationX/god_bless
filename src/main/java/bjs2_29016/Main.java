package bjs2_29016;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<WebPage>> searchRequestsByWord = new HashMap<>();
        Map<String, List<String>> urlToKeyWords = new HashMap<>();

        indexWebPage(searchRequestsByWord, urlToKeyWords, new WebPage("faang-school.com",
                "Faang School", "Java is the best programming language"));
        indexWebPage(searchRequestsByWord, urlToKeyWords, new WebPage("some-page.com",
                "Some random page", "Java is not the best programming language"));

        System.out.println(searchRequestsByWord);
        System.out.println();

        System.out.println(searchByKeyWord(searchRequestsByWord, "Java"));
        System.out.println();

        deleteFromIndexByUrl(searchRequestsByWord, urlToKeyWords, "some-page.com");
        System.out.println(searchRequestsByWord);
    }

    public static void indexWebPage(Map<String, List<WebPage>> searchRequestsByWord,
                                    Map<String, List<String>> urlToKeyWords,
                                    WebPage webPage) {
        String url = webPage.getUrl();
        String[] words = webPage.getContent().split(" ");

        for (String word : words) {
            searchRequestsByWord.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
            urlToKeyWords.computeIfAbsent(url, k -> new ArrayList<>()).add(word);
        }
    }

    public static List<WebPage> searchByKeyWord(Map<String, List<WebPage>> searchRequestsByWord, String word) {
        return searchRequestsByWord.getOrDefault(word, new ArrayList<WebPage>());
    }

    public static void deleteFromIndexByUrl(Map<String, List<WebPage>> searchRequestsByWord,
                                            Map<String, List<String>> urlToKeyWords,
                                            String url) {
        List<String> keyWords = urlToKeyWords.remove(url);
        for (String word : keyWords) {
            searchRequestsByWord.get(word).removeIf(n -> n.getUrl().equals(url));
        }

        searchRequestsByWord.entrySet().removeIf(k -> k.getValue().isEmpty());
    }
}
