package school.faang.BJ32893;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> INDEX = new HashMap<>();

    void indexWebPage(WebPage webPage) {
        String content = webPage.getContent();
        String[] words = content.split("\\s+");

        for (String keyword : words) {
            keyword = keyword.toLowerCase();
            INDEX.putIfAbsent(keyword, new ArrayList<>());
            INDEX.get(keyword).add(webPage);
        }
    }

    List<WebPage> searchWebPage(String keyword) {
        List<WebPage> listOfPages = INDEX.get(keyword);
        if (listOfPages == null) {
            throw new IllegalArgumentException("404 not found");
        }
        return listOfPages;
    }

    List<WebPage> deletePageByUrl(String url) {
        List<WebPage> listPages = new ArrayList<>();

        for (Map.Entry<String, List<WebPage>> entry : INDEX.entrySet()) {
            List<WebPage> webPages = entry.getValue();
            Iterator<WebPage> iterator = webPages.iterator();
            while (iterator.hasNext()) {
                WebPage webPage = iterator.next();
                if (webPage.getUrl().equals(url)) {
                    listPages.add(webPage);
                    iterator.remove();
                }
            }
            if (webPages.isEmpty()) {
                iterator.remove();
            }
        }
        return listPages;
    }
}
