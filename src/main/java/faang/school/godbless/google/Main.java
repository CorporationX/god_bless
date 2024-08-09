package faang.school.godbless.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> wordPagesMap = new HashMap<>();
    private static final Map<String, List<WebPage>> urlPagesMap = new HashMap<>();

    private void addToIndex(WebPage webPage) {

        String[] words = webPage.getContent().split("\\W+");

        Arrays.stream(words)
                .forEach(word -> wordPagesMap.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage));
    }

    private List<WebPage> findWebPages(String keyWord) {
        return wordPagesMap.get(keyWord);
    }

    private void deleteByUrl(String url) {
        for (List<WebPage> webPages : wordPagesMap.values()) {
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }

        wordPagesMap.values().removeIf(List::isEmpty);
    }
}
