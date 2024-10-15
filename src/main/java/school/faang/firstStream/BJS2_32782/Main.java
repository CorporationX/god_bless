package school.faang.firstStream.BJS2_32782;

import java.util.*;

public class Main {
    private static final Map<String, List<WebPage>> WORD_INDEX = new HashMap<>();
    private static final String WORD_SPLITTER_REGEX = "[(\\s,.\"!?:';)]+";


    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split(WORD_SPLITTER_REGEX);

        for (String word : words) {
            WORD_INDEX.computeIfAbsent(word, key -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> searchWebPageByIndex(String word) {
        return WORD_INDEX.get(word.toLowerCase());
    }

    private static void deleteWebPageByUrl(String url) {
        for (List<WebPage> pages : WORD_INDEX.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }

    public static void main(String[] args) {
        indexWebPage(new WebPage("namba.kg", "News, Movies and Music", "New movies every day"));
        indexWebPage(new WebPage("amazon.de", "Dyson Mayson", "Hello, Dayson today only for 599$"));
        indexWebPage(new WebPage("udemi.com", "Zaur Tregulov java kurs", "Hello,this is my new course"));
        indexWebPage(new WebPage("google.com", "NBA games today", "New day new games"));
        indexWebPage(new WebPage("youtube.com", "Mr. Beast with Argen Sigma", "Hello, this is collaboration of the year"));

        System.out.println(WORD_INDEX);

        System.out.println(searchWebPageByIndex("Hello"));

        deleteWebPageByUrl("udemi.com");
        System.out.println(WORD_INDEX);
    }
}
