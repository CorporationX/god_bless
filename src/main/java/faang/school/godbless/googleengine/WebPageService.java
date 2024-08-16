package faang.school.godbless.googleengine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WebPageService {

    public void addWebPage(Map<String, Set<WebPage>> webPagesMap, WebPage webPage) {
        var keyWords = webPage.getContent().split(",");

        Arrays.stream(keyWords)
                .map(word -> word.replaceAll("\\p{Punct}", "").trim())
                .filter(word -> word.length() > 1)
                .forEach(word -> webPagesMap.computeIfAbsent(word, k -> new HashSet<>()).add(webPage));
    }

    public Set<WebPage> findPagesByKeyWord(Map<String, Set<WebPage>> webPagesMap, String keyWord) {
        var foundPages = webPagesMap.get(keyWord);

        if (foundPages == null) {
            System.out.println("Pages by key word: " + keyWord + " not found!");
        }

        return foundPages;
    }

    public void removePageByUrl(Map<String, Set<WebPage>> webPagesMap, String url) {
        webPagesMap.values().forEach(key -> key.removeIf(value -> value.getUrl().equals(url)));
        webPagesMap.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

    public void webPagesInfo(Map<String, Set<WebPage>> webPagesMap) {
        System.out.println("WebPages by key word");
        webPagesMap.forEach((keyWord, webPages) -> {
            System.out.println(keyWord + ":");
            webPages.forEach(webPage -> System.out.println(" " + webPage.getTitle() + ", " + webPage.getUrl()));
            System.out.println();
        });
    }

}
