package faang.school.godbless.BJS2_20195;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public class SearchEngineService {

    private Map<String, Set<WebPage>> index;

    public SearchEngineService() {
        this.index = new HashMap<>();
    }

    public void indexWebPage(WebPage page) {
        String[] content = concatTwoArray(page.getTitle().split(" "), page.getContent().split(" "));
        for (String word : content) {
            Set<WebPage> pages = index.getOrDefault(word, new HashSet<>());
            pages.add(page);
            index.put(word, pages);
        }
    }

    private String[] concatTwoArray(String[] arr1, String[] arr2) {
        return Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray(String[]::new);
    }

    public Set<WebPage> getWebPages(String word) {
        return index.getOrDefault(word, new HashSet<>());
    }

    public void removeWebPage(String url) {
        Iterator<String> iterator = index.keySet().iterator();
        while (iterator.hasNext()) {
            Set<WebPage> pages = index.get(iterator.next());
            pages.removeIf(webPage -> webPage.getUrl().equals(url));

            if (pages.isEmpty()) {
                iterator.remove();
            }
        }
    }
}
