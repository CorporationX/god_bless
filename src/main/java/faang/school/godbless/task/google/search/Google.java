package faang.school.godbless.task.google.search;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Google {
    private final Map<String, List<WebPage>> wordAndWebPagesListMap;
    private final Map<String, Set<String>> urlAndWordsMap;

    public void scanWebPage(WebPage webPage) {
        validateWebPage(webPage);
        String[] words = webPage.content().concat(webPage.title()).split("\\W+");
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word.toLowerCase());
        }
        urlAndWordsMap.put(webPage.url(), wordsSet);
        for (String word : wordsSet) {
            wordAndWebPagesListMap.computeIfAbsent(word,
                    k -> new ArrayList<>()).add(webPage);
        }
    }

    public List<WebPage> findWebPagesByWord(String word) {
        if (!wordAndWebPagesListMap.containsKey(word.toLowerCase())) {
            webPagesNotFound(word);
        }
        return wordAndWebPagesListMap.get(word.toLowerCase());
    }

    public void deleteWebPageByUrl(String url) {
        if (!urlAndWordsMap.containsKey(url)) {
            webPagesNotFoundByUrl(url);
        }
        for (String word : urlAndWordsMap.get(url)) {
            var webPages = wordAndWebPagesListMap.get(word);
            if (webPages != null) {
                webPages.removeIf(page -> page.url().equals(url));
                if (webPages.isEmpty()) {
                    wordAndWebPagesListMap.remove(word);
                }
            } else {
                wordAndWebPagesListMap.remove(word);
            }
        }
    }

    private void validateWebPage(WebPage webPage) {
        if (webPage == null) {
            throw new IllegalArgumentException("Веб страница не может быть null");
        }
    }

    private void webPagesNotFound(String word) {
        throw new NoSuchElementException("Веб страницы с словом %s не найдены".formatted(word));
    }

    private void webPagesNotFoundByUrl(String url) {
        throw new NoSuchElementException("Веб страница с адресом %s не найдена".formatted(url));
    }
}
