package faang.school.godbless.bjs220404;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchEngine {
    public void indexPage(Map<String, List<WebPage>> indexedPages, WebPage webPage) {
        Set<String> words = Set.of(webPage.getContent().split(" "));
        words.forEach(word ->
                indexedPages.computeIfAbsent(word.toLowerCase(), k -> new ArrayList<>()).add(webPage)
        );
    }

    public List<WebPage> search(Map<String, List<WebPage>> indexedPages, String word) {
        return indexedPages.get(word);
    }

    public void deleteWebPage(Map<String, List<WebPage>> indexedPages, String url) {
        for (List<WebPage> webPages : indexedPages.values()) {
            for (WebPage webPage : webPages) {
                if (webPage.getUrl().equals(url)) {
                    Set<String> words = Set.of(webPage
                            .getContent()
                            .split(" "));
                    for (String word : words) {
                        indexedPages.get(word.toLowerCase()).removeIf(
                                webPageByIndex -> webPageByIndex.getUrl().equals(url));
                    }
                    return;
                }
            }
        }
    }
}
