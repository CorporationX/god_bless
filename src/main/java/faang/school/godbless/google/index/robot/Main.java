package faang.school.godbless.google.index.robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final Map<String, List<WebPage>> wordPagesMap = new HashMap<>();
    private static final Map<String, Set<String>> urlWordsMap = new HashMap<>();

    private void addToIndex(WebPage webPage) {
        String[] words = webPage.getContent().split("\\W+");
        Arrays.stream(words)
                .forEach(word -> wordPagesMap.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage));
        urlWordsMap.put(webPage.getUrl(), Arrays.stream(words).collect(Collectors.toSet()));
    }

    private List<WebPage> findWebPages(String keyWord) {
        return wordPagesMap.get(keyWord);
    }

    private void deleteByUrl(String url) {
        Set<String> words = urlWordsMap.get(url);
        for (String word : words) {
            List<WebPage> webPages = wordPagesMap.get(word);
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
