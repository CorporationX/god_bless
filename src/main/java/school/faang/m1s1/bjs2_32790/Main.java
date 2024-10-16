package school.faang.m1s1.bjs2_32790;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, Set<WebPage>> WORD_INDEX = new HashMap<>();
    private static final Map<String, WebPage> URL_INDEX = new HashMap<>();
    private static final String WORD_SPLITTER_REGEX = "[(\s,.\"!?:';)]+";

    public static void main(String[] args) {

        indexWebPage(new WebPage("yandex.ru", "News", "Hello world! мир! :)"));
        indexWebPage(new WebPage("google.com", "Recent", "Привет, Мир!"));
        indexWebPage(new WebPage("faang-school.net", "Java Bootcamp", "Hello Mentor, spare me please!"));
        indexWebPage(new WebPage("school.ru", "Stupid camp", "Hello I love world!"));
        indexWebPage(new WebPage("youtube.com", "Puppies video", "Hello cuties"));

        System.out.println(WORD_INDEX);

        System.out.println(searchByIndex("HELLO"));

        deleteByUrl("faang-school.net");
        System.out.println(WORD_INDEX);
    }

    private static void indexWebPage(WebPage webPage) {
        String url = webPage.getUrl();
        URL_INDEX.put(url, webPage);

        String content = webPage.getContent();
        String[] words = content.toLowerCase().split(WORD_SPLITTER_REGEX);
        for (String word : words) {
            WORD_INDEX.computeIfAbsent(word, key -> new HashSet<>()).add(webPage);
        }
    }

    private static Set<WebPage> searchByIndex(String word) {
        return WORD_INDEX.get(word.toLowerCase());
    }

    private static void deleteByUrl(String url) {
        WebPage targetPage = URL_INDEX.remove(url);
        for (var entry : WORD_INDEX.entrySet()) {
            Set<WebPage> webPageSet = entry.getValue();
            webPageSet.remove(targetPage);
        }
    }
}
