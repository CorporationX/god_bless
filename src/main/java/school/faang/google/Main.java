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
    private final static Map<String, List<WebPage>> WEBB_PAGE_LIST_OF_WORDS = new HashMap<>();
    //содержит url страницы и множество слов принадлежащих этой странице
    private final static Map<String, Set<String>> WORDS_LIST_OF_URL = new HashMap<>();


    public static void main(String[] args) {
        WebPage pageFirst = new WebPage("https://faang-school.com", "Faang School", "Falls du es " +
                "eilig hast und du nur die Zeit hast ein einziges Kapitel dieses hervorragendes Buches durchzulesen," +
                " bist du hier genau richtig");
        WebPage pageSecond = new WebPage("https://result-school.com", "Result School",
                "Dieses Kapitel behandelt alle grundlegenden Befehle, die du benötigst, um den großteil" +
                        " der Aufgaben zu erledigen");
        indexingNewPage(pageFirst);
        indexingNewPage(pageSecond);
        System.out.println(WEBB_PAGE_LIST_OF_WORDS);
        System.out.println(WORDS_LIST_OF_URL);
        System.out.println("----------------");
        System.out.println(searchPage("du"));
        removeWebPage(pageSecond);
        System.out.println(WEBB_PAGE_LIST_OF_WORDS);
        System.out.println(WORDS_LIST_OF_URL);
    }

    public static void indexingNewPage(WebPage page) {
        String url = page.url();
        String content = page.content();
        Set<String> setWords = new HashSet<>(Arrays.asList(content.split("\\PL")));
        WORDS_LIST_OF_URL.put(url, setWords);
        for (String word : setWords) {
            WEBB_PAGE_LIST_OF_WORDS.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> searchPage(String word) {
        return WEBB_PAGE_LIST_OF_WORDS.get(word);
    }

    public static void removeWebPage(WebPage page) {
        Set<String> wordsFromUrl = WORDS_LIST_OF_URL.get(page.url());
        WORDS_LIST_OF_URL.remove(page.url());
        for (String word : wordsFromUrl) {
            WEBB_PAGE_LIST_OF_WORDS.get(word).remove(page);
        }
    }

}
