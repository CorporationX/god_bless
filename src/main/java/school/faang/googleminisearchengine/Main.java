package school.faang.googleminisearchengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static Map<String, List<WebPage>> index = new HashMap<>();
    static Map<String, WebPage> webPagesByUrl = new HashMap<>();
    static Map<WebPage, Set<String>> wordsByWebPage = new HashMap<>();

    public static List<WebPage> searchByWord(String word) {
        return index.getOrDefault(word, List.of());
    }

    public static void indexWebPage(WebPage webPage) {
        webPagesByUrl.put(webPage.getUrl(), webPage);

        Set<String> words = getWebPageWords(webPage);

        wordsByWebPage.put(webPage, words);

        words.forEach(
                word -> index.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage)
        );
    }

    public static void removeWebPageByUrl(String url) {
        WebPage webPageToRemove = webPagesByUrl.remove(url);
        if (webPageToRemove == null) {
            return;
        }

        Set<String> words = wordsByWebPage.remove(webPageToRemove);

        words.forEach(
                word ->
                        index.compute(word,
                                (k, v) -> {
                                    if (v == null) {
                                        throw new RuntimeException("Alarm, consistency is broken!!!");
                                    }
                                    v.remove(webPageToRemove);
                                    if (v.isEmpty()) {
                                        return null;
                                    }
                                    return v;
                                }
                        )
        );
    }

    private static Set<String> getWebPageWords(WebPage webPage) {
        return Stream.concat(
                        splitByWords(webPage.getTitle()),
                        splitByWords(webPage.getContent())
                )
                .collect(Collectors.toSet());
    }

    private static Stream<String> splitByWords(String s) {
        return Stream.of(s.split(" "));
    }
}
