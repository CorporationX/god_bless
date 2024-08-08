package faang.school.godbless.BJS2_20300;

import lombok.Data;

import java.util.*;

@Data
public class Main {
    private Map<String, List<WebPage>> wordsPages = new HashMap<>();

    public void indexationNewWebPage(WebPage webPage) {
        List<String> wordsWebPage = Arrays.stream(webPage.getContent().toLowerCase().split(" ")).toList();
        for (String word : wordsWebPage) {
            wordsPages.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public List<WebPage> findWebPage(String word) {
        return wordsPages.getOrDefault(word.toLowerCase(), new ArrayList<>());
    }

    public void removeWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : wordsPages.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
