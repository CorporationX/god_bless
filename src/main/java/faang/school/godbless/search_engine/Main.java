package faang.school.godbless.search_engine;

import java.util.*;

public class Main {
    private Map<String, List<WebPage>> pageMap = new HashMap<>();

    public void indexPage(WebPage page) {
        String pageAllText = page.title() + " " + page.content() + " " + page.url();
        String[] keyWords = pageAllText.replaceAll("[-+.^:,]", " ").toLowerCase().split(" ");
        for (String keyWord : keyWords) {
            List<WebPage> list = pageMap.computeIfAbsent(keyWord, k -> new ArrayList<>());
            if (!list.contains(page)) {
                list.add(page);
            }
        }
    }

    public List<WebPage> search(String searchQuery) {
        return pageMap.get(searchQuery);
    }

    public void hostServerGoesOffline(String url) {
        List<String> keysToRemove = new ArrayList<>();

        for (Map.Entry<String, List<WebPage>> entry : pageMap.entrySet()) {
//            cool, thanks Intellij
            entry.getValue().removeIf(page -> Objects.equals(page.url(), url));
            if (entry.getValue().isEmpty()) {
                keysToRemove.add(entry.getKey());
            }
        }

        for (String key : keysToRemove) {
            pageMap.remove(key);
        }
    }
}
