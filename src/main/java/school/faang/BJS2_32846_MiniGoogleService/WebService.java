package school.faang.BJS2_32846_MiniGoogleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebService {
    private Map<String, List<WebPage>> wordToPages;
    private Map<String, WebPage> alreadyIndexedPages;
    private Map<String, Set<String>> pageToWords;

    public WebService() {
        wordToPages = new HashMap<>();
        alreadyIndexedPages = new HashMap<>();
        pageToWords = new HashMap<>();
    }

    public void indexWebPage(WebPage page) {
        if (!alreadyIndexedPages.containsKey(page.getUrl())) {
            String[] words = page.getContent().toLowerCase().split("\\W+");
            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
            uniqueWords.forEach(
                    word -> wordToPages
                            .computeIfAbsent(word, wordOnPage -> new ArrayList<>())
                            .add(page)
            );
            pageToWords.put(page.getUrl(), uniqueWords);
            alreadyIndexedPages.put(page.getUrl(), page);
        }
    }

    public List<WebPage> getWebPages(String word) {
        return wordToPages.get(word.toLowerCase());
    }

    public void removeWebPage(String url) {
        WebPage page = alreadyIndexedPages.remove(url);
        Set<String> wordsOnPage = pageToWords.remove(url);
        for (String word: wordsOnPage) {
            List<WebPage> pages = wordToPages.get(word);
            pages.remove(page);
            if (pages.isEmpty())
                wordToPages.remove(word);
        }
    }

    public int getWordsCount() {
        return wordToPages.size();
    }
}
