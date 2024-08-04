package faang.school.godbless.BJS2_20051;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {
    HashMap<String, List<WebPage>> searchEngine = new HashMap<>();

    public static void main(String[] args) {

    }

    public void indexingWebPage(WebPage webPage) {
        String[] words = webPage.getContext().split("\\s+");
        for(var word : words) {
            searchEngine.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public List<WebPage> searchByKeyword(String string) {
        return searchEngine.get(string);
    }

    public void deleteByURL(String url) {
        for(var entry : searchEngine.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
