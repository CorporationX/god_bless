package school.faang.googleminisearchengine;

import java.util.ArrayList;
import java.util.Iterator;

import static school.faang.googleminisearchengine.Main.EXISTING_PAGES;
import static school.faang.googleminisearchengine.Main.WEB_PAGES;


public class WebPageService {
    public static void indexingNewWebPage(WebPage webPage) {
        if (!EXISTING_PAGES.contains(webPage)) {
            String[] keyWords = webPage.getContent().split(" ");
            for (int i = 0; i < keyWords.length; i++) {
                WEB_PAGES.put(keyWords[i], WEB_PAGES.computeIfAbsent(
                        keyWords[i], keyWord -> new ArrayList<>())).add(webPage);
                EXISTING_PAGES.add(webPage);
            }
        } else {
            System.out.println("This page is already indexed");
        }
    }

    public static ArrayList<WebPage> getWebPagesByKeyWord(String keyWord) {
        ArrayList<WebPage> webPagesByKeyWord = new ArrayList<>();
        for (var entry : WEB_PAGES.entrySet()) {
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

    public static void removePageByUrl(String url) {
        for (var entry : WEB_PAGES.entrySet()) {
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

    public static void testPrintAllPages() {
        for (var entry : WEB_PAGES.entrySet()) {
            System.out.println("Keyword:" + entry.getKey() + " | "
                    + "List of pages: " + entry.getValue());
        }
    }
}
