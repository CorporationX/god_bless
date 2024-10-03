package school.faang.bjs2_32790;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, Set<WebPage>> wordIndex = new HashMap<>();
    private static final Map<String, WebPage> urlIndex = new HashMap<>();

    public static void main(String[] args) {

        indexWebPage(new WebPage("yandex.ru", "News", "Hello world! мир! :)"));
        indexWebPage(new WebPage("google.com", "Recent", "Привет, Мир!"));
        indexWebPage(new WebPage("faang-school.net", "Java Bootcamp", "Hello Mentor, spare me please!"));
        indexWebPage(new WebPage("school.ru", "Stupid camp", "Hello I love world!"));
        indexWebPage(new WebPage("youtube.com", "Puppies video", "Hello cuties"));

        System.out.println(wordIndex);

        System.out.println(searchByIndex("HELLO"));

        deleteByUrl("faang-school.net");
        System.out.println(wordIndex);
    }

    private static void indexWebPage(WebPage webPage) {
        String url = webPage.getUrl();
        urlIndex.put(url, webPage);

        String content = webPage.getContent();
        String[] words = content.toLowerCase().split("[(\s,.\"!?:';)]+");
        for (String word : words) {
            wordIndex.computeIfAbsent(word, key -> new HashSet<>()).add(webPage);
        }
    }

    private static Set<WebPage> searchByIndex(String word) {
        return wordIndex.get(word.toLowerCase());
    }

    private static void deleteByUrl(String url) {
        WebPage targetPage = urlIndex.remove(url);
        for (var entry : wordIndex.entrySet()) {
            Set<WebPage> webPageSet = entry.getValue();
            webPageSet.remove(targetPage);
        }
    }
}
