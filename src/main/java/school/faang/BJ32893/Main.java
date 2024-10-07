package school.faang.BJ32893;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> INDEX = new HashMap<>();
    private static final Map<String, List<String>> urlToWords = new HashMap<>();

    public static void indexWebPage(WebPage webPage) {
        String content = webPage.getContent();
        String[] words = content.split("\\s+");
        String url = webPage.getUrl();
        List<String> listOfWords = new ArrayList<>();

        for (String keyword : words) {
            keyword = keyword.toLowerCase();
            INDEX.putIfAbsent(keyword, new ArrayList<>());
            INDEX.get(keyword).add(webPage);
            listOfWords.add(keyword);
        }
        urlToWords.put(url, listOfWords);
    }

    public static List<WebPage> searchWebPage(String keyword) {
        List<WebPage> listOfPages = INDEX.get(keyword);
        if (listOfPages == null) {
            throw new IllegalArgumentException("404 not found " + keyword);
        }
        return listOfPages;
    }

    public static List<WebPage> deletePageByUrl(String url) {
        List<WebPage> listPages = new ArrayList<>();
        List<String> keywords = urlToWords.get(url);

        if (keywords == null) {
            return listPages;
        }

        for (String keyword : keywords) {
            List<WebPage> webPages = INDEX.get(keyword);
            if (webPages != null) {
                Iterator<WebPage> iterator = webPages.iterator();
                while (iterator.hasNext()) {
                    WebPage webPage = iterator.next();
                    if (webPage.getUrl().equals(url)) {
                        listPages.add(webPage);
                        iterator.remove();
                    }
                }
                if (webPages.isEmpty()) {
                    INDEX.remove(keyword);
                }
            }
        }
        return listPages;
    }
}
