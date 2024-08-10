package faang.school.godbless.google;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Main {
    private Map<String, List<WebPage>> index;

    public void indexWebPage(WebPage page) {
        String[] words = page.getContent().toLowerCase().split("\\W+");
        for (String word : words) {
            if (!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
            }
            index.get(word).add(page);
        }
    }

    public List<WebPage> getWebPages(String keyWord) {
        return index.get(keyWord.toLowerCase());
    }

    public void deleteWebPage(String url) {
        for (List<WebPage> pages : index.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}
