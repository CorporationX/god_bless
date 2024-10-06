package engineGoogle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebIndexer {

    private final Map<String, List<WebPage>> indexMap = new HashMap<>();

    public void addIndexMap(WebPage page) {
        String content = page.getContent();
        String[] words = content.toLowerCase().split("\\W+");

        for (String word : words) {
            List<WebPage> webPageList = indexMap.computeIfAbsent(word, key -> new ArrayList<>());
            webPageList.add(page);
        }
    }

    public List<WebPage> findWebPage(String word) {
        String wordFind = word.toLowerCase();
        return indexMap.get(wordFind);
    }

    public void removeWepPage(String url) {
        List<WebPage> pageToRemove = new ArrayList<>();

        for (String word : indexMap.keySet()) {
            List<WebPage> pageList = indexMap.get(word);
            for (WebPage page : pageList) {
                if (page.getUrl().equals(url)) {
                    pageToRemove.add(page);
                }
            }

            for (WebPage pageRe : pageToRemove) {
                indexMap.get(word).remove(pageRe);
            }

            pageToRemove.clear();
        }
    }

    public void printPages() {
        for (Map.Entry<String, List<WebPage>> entry : indexMap.entrySet()) {
            System.out.println("Поисковое слово: " + entry.getKey() + "\tСписок сайтов " + entry.getValue());
        }
    }
}
