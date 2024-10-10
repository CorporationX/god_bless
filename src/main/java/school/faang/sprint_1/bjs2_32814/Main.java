package school.faang.sprint_1.bjs2_32814;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    static final Map<String, Set<WebPage>> WORD_INDEX = new HashMap<>();
    static final Map<String, WebPage> URL_INDEX = new HashMap<>();
    static final String SPLIT_RULE = "[( ,.\"!?:';)]+";

    static void indexWebPage(WebPage webPage) {
        String url = webPage.getUrl();
        String content = webPage.getContent();
        String[] words = content.toLowerCase().split(SPLIT_RULE);
        URL_INDEX.put(url, webPage);

        for (String word : words) {
            WORD_INDEX.computeIfAbsent(word, key -> new HashSet<>()).add(webPage);
        }
    }

    static Set<WebPage> searchByIndex(String word) {
        return WORD_INDEX.get(word.toLowerCase());
    }

    static void deleteByUrl(String url) {
        WebPage targetPage = URL_INDEX.remove(url);
        for (var entry : WORD_INDEX.entrySet()) {
            Set<WebPage> webPageSet = entry.getValue();
            webPageSet.remove(targetPage);
        }
    }
}
