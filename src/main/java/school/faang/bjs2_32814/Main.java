package school.faang.bjs2_32814;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    protected static final Map<String, Set<WebPage>> wordIndex = new HashMap<>();
    protected static final Map<String, WebPage> urlIndex = new HashMap<>();

    static void indexWebPage(WebPage webPage) {
        String url = webPage.getUrl();
        String content = webPage.getContent();
        String[] words = content.toLowerCase().split("[( ,.\"!?:';)]+");
        urlIndex.put(url, webPage);

        for (String word : words) {
            wordIndex.computeIfAbsent(word, key -> new HashSet<>()).add(webPage);
        }
    }

    static Set<WebPage> searchByIndex(String word) {
        return wordIndex.get(word.toLowerCase());
    }

    static void deleteByUrl(String url) {
        WebPage targetPage = urlIndex.get(url);
        for (var entry : wordIndex.entrySet()) {
            Set<WebPage> webPageSet = entry.getValue();
            webPageSet.remove(targetPage);
        }
        urlIndex.remove(url);
    }
}
