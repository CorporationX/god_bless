package school.faang.search.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SearchEngine {
    private final Map<String, Map<String, WebPage>> wordToPages = new HashMap<>();
    private final Map<String, Set<String>> urlToWords = new HashMap<>();

    public void add(WebPage page) {
        Objects.requireNonNull(page, "page is null");
        String[] wordsArr = page.getContent().split("\\PL+");
        Set<String> words = new HashSet<>(Arrays.asList(wordsArr));

        //Добавление в индекс
        for (String word : words) {
            Map<String, WebPage> pages = wordToPages.getOrDefault(word, new HashMap<>());
            pages.put(page.getUrl(), page);
            wordToPages.put(word, pages);
        }

        //обновляем вспомогательный индекс
        urlToWords.put(page.getUrl(), words);
    }

    public List<WebPage> getPages(String word) {
        return new ArrayList<>(wordToPages.get(word).values());
    }

    public void remove(String url) {
        Set<String> words = urlToWords.get(url);
        if (words == null) {
            return;
        }

        //удаление из индекса
        for (String word : words){
            Map<String, WebPage> urlToPage = wordToPages.get(word);
            urlToPage.remove(url);
        }

        //обновление вспомогательного индекса
        urlToWords.remove(url);
    }
}
