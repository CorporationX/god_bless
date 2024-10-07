package school.faang.task134;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebPageService {
    private static final HashMap<String, List<WebPage>> KeyWordInWebPage = new HashMap<>();

    public static void indexNewWebPage(WebPage webPage) {
        String[] words = webPage.getContent()
                .replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "")
                .toLowerCase()
                .split("\\s");
        for (String word : words) {
            KeyWordInWebPage.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPage(String word) {
        return KeyWordInWebPage.get(word.toLowerCase());
    }

    public static void removeByUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : KeyWordInWebPage.entrySet()) {
            entry.getValue().removeIf(webPage -> (webPage.getUrl().equals(url)));
        }
    }
    public static void printAll(){
        for (Map.Entry<String, List<WebPage>> entry : KeyWordInWebPage.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
