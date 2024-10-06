package school.faang.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    //слово + список страниц
    private final static Map<String, List<WebPage>> WORDS = new HashMap<>();
    //содержит url страницы и множество слов принадлежащих этой странице
    private final static Map<String, Set<String>> URLS = new HashMap<>();


    public static void main(String[] args) {
    }

    public static void indexingNewPage(WebPage page) {
        String url = page.url();
        String content = page.content();
        Set<String> setWords = new HashSet<>(Arrays.asList(content.split("\\PL")));
        URLS.put(url, setWords);
        for (String word : setWords) {
            WORDS.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> searchPage(String word) {
        return WORDS.get(word);
    }

    public static void removeWebPage(WebPage page) {
        Set<String> wordsFromUrl = URLS.get(page.url());
        URLS.remove(page.url());
        for (String word : wordsFromUrl) {
            WORDS.get(word).remove(page);
        }
    }

}
