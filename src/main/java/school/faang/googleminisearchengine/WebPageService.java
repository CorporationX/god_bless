package school.faang.googleminisearchengine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WebPageService {
    public static void indexingNewWebPage(WebPage webPage, Set<WebPage> existingPages, Map<String, ArrayList<WebPage>> webPages) {
        if (!existingPages.contains(webPage)) {
            String[] keyWords = webPage.getContent().split(" ");
            for (int i = 0; i < keyWords.length; i++) {
                webPages.put(keyWords[i], webPages.computeIfAbsent(
                        keyWords[i], keyWord -> new ArrayList<>())).add(webPage);
                existingPages.add(webPage);
            }
        } else {
            System.out.println("This page is already indexed");
        }
    }

    public static ArrayList<WebPage> getWebPagesByKeyWord(String keyWord,  Map<String, ArrayList<WebPage>> webPages) {
        ArrayList<WebPage> webPagesByKeyWord = new ArrayList<>();
        for (var entry : webPages.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(keyWord)) {
                for (WebPage page : entry.getValue()) {
                    webPagesByKeyWord.add(page);
                }
            }
        }
        if (webPagesByKeyWord.isEmpty()) {
            System.out.println("No pages were found matching the keyword");
        }
        return webPagesByKeyWord;
    }

    public static void removePageByUrl(String url, Map<String, ArrayList<WebPage>> webPages) {
        for (var entry : webPages.entrySet()) {
            ArrayList<WebPage> pages = entry.getValue();

            Iterator<WebPage> iterator = pages.iterator();
            while (iterator.hasNext()) {
                WebPage webPage = iterator.next();
                if (webPage.getUrl().equalsIgnoreCase(url)) {
                    iterator.remove();
                }
            }
        }
    }

    public static void testPrintAllPagesByKeyWord(ArrayList<WebPage> pages) {
        for (WebPage page : pages) {
            System.out.println(page);
        }
    }

    public static void testPrintAllPages(Map<String, ArrayList<WebPage>> webPages) {
        for (var entry : webPages.entrySet()) {
            System.out.println("Keyword:" + entry.getKey() + " | "
                    + "List of pages: " + entry.getValue());
        }
    }
}
