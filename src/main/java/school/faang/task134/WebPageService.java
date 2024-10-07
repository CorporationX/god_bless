package school.faang.task134;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebPageService {
    @Getter
    private static final HashMap<String, List<WebPage>> index = new HashMap<>();
    public static void indexNewWebPage(WebPage webPage) {
        String[] words = webPage.getContent()
                .replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "")
                .toLowerCase()
                .split("\\s");
        for (String word : words) {
            index.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPage(String word) {
        return index.get(word.toLowerCase());
    }

    public static void removeByUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : index.entrySet()) {
            entry.getValue().removeIf(webPage -> (webPage.getUrl().equals(url)));
        }
    }
    public static void printAll(){
        for (Map.Entry<String, List<WebPage>> entry : index.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
