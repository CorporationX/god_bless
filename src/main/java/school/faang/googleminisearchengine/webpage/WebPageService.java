package school.faang.googleminisearchengine.webpage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WebPageService {

    private static final Map<String, List<WebPage>> index = new HashMap<>();
    private static final Map<String, WebPage> webPagesByUrl = new HashMap<>();
    private static final Map<WebPage, Set<String>> wordsByWebPage = new HashMap<>();

    public static List<WebPage> searchByWord(String word) {
        return index.getOrDefault(word.trim().toLowerCase(), List.of());
    }

    public static void indexWebPage(WebPage webPage) {
        validateWebPage(webPage);
        clearIndexIfPresent(webPage);

        webPagesByUrl.put(webPage.getUrl(), webPage);

        Set<String> words = getWebPageWords(webPage);
        wordsByWebPage.put(webPage, words);

        words.forEach(
                word -> index.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage)
        );
    }

    private static void clearIndexIfPresent(WebPage webPage) {
        if (webPagesByUrl.containsKey(webPage.getUrl())) {
            WebPage oldWebPage = webPagesByUrl.get(webPage.getUrl());
            removeWebPageByUrl(oldWebPage.getUrl());
        }
    }

    private static void validateWebPage(WebPage webPage) {
        String url = webPage.getUrl();
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("Webpage url is empty");
        }
    }

    public static void removeWebPageByUrl(String url) {
        WebPage webPageToRemove = webPagesByUrl.remove(url);
        if (webPageToRemove == null) {
            return;
        }

        Set<String> webPageWords = wordsByWebPage.remove(webPageToRemove);


        for (String word : webPageWords) {
            removeWebPageByWord(word, webPageToRemove);
        }
    }

    private static void removeWebPageByWord(String word, WebPage webPageToRemove) {
        index.compute(word,
                (k, v) -> removeWebPageFromList(v, webPageToRemove)
        );
    }

    private static List<WebPage> removeWebPageFromList(List<WebPage> webPages, WebPage webPageToRemove) {
        if (webPages == null) {
            throw new RuntimeException("Alarm, consistency is broken!!!");
        }

        webPages.remove(webPageToRemove);
        if (webPages.isEmpty()) {
            return null;
        }
        return webPages;
    }

    private static Set<String> getWebPageWords(WebPage webPage) {
        return Stream.concat(
                        splitByWords(webPage.getTitle()),
                        splitByWords(webPage.getContent())
                )
                .collect(Collectors.toSet());
    }

    private static Stream<String> splitByWords(String s) {
        return Stream.of(s.split(" "))
                .map( str -> str.trim().toLowerCase())
                .flatMap( str -> Stream.of(str.split("[^\\w-]")))
                .filter( str -> !str.isEmpty() );
    }
}
