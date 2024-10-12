package school.faang.googlesearchengine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebPageIndex {
    private static Map<String, List<WebPage>> index;

    public WebPageIndex() {
        this.index = new HashMap<>();
    }

    public void indexNewPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split("\\W++");
        for (String word : words) {
            if (!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
            }
            index.get(word).add(webPage);
        }

    }

    public List<WebPage> webPageByKeyword(String key) {
        return index.getOrDefault(key.toLowerCase(), Collections.emptyList());

    }

    public void removeWebPage(String url) {
        for (List<WebPage> webPages : index.values()) {
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
