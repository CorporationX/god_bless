package faang.school.godbless.task.google.search;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Google {
    private final Map<String, List<WebPage>> wordWebPagesListMap;
    private final Map<String, Set<String>> urlWordsMap;

    public void scanWebPage(WebPage webPage) {
        String[] words = webPage.content().concat(webPage.title()).split("\\W+");
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word.toLowerCase());
        }
        urlWordsMap.put(webPage.url(), wordsSet);
        for (String word : wordsSet) {
            wordWebPagesListMap.computeIfAbsent(word.toLowerCase(),
                    k -> new ArrayList<>()).add(webPage);
        }
    }

    public List<WebPage> findWebPagesByWord(String word) {
        return wordWebPagesListMap.get(word.toLowerCase());
    }

    public void deleteWebPageByUrl(String url) {
        for (String word : urlWordsMap.get(url)) {
            var webPages = wordWebPagesListMap.get(word);
            if (webPages != null) {
                webPages.removeIf(page -> page.url().equals(url));
                if (webPages.isEmpty()) {
                    wordWebPagesListMap.remove(word);
                }
            }
        }
    }
}
