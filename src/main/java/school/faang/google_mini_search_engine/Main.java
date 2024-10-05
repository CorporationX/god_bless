package school.faang.google_mini_search_engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static final HashMap<String, ArrayList<WebPage>> WEB_PAGES = new HashMap<>();

    public static void main(String[] args) {
        indexingNewWebPage(new WebPage("https://docs.oracle.com/", "Class String",
                "Strings are constant and can't be modified"));
        indexingNewWebPage(new WebPage("https://docs.oracle.com/",
                "Class StringBuffer",
                "A string buffer can be modified"));
        indexingNewWebPage(new WebPage("https://modifiedapps.com/",
                "MODIFIED APPS",
                "Modded apps are simply modified versions of the original mobile app"));
        indexingNewWebPage(new WebPage("https://faang-school.com/courses/",
                "Java HashMap",
                "Key-value data structure, also known as associative array"));

        ArrayList<WebPage> testWebPagesByKeyWord = getWebPagesByKeyWord("modified");
        testPrintAllPagesByKeyWord(testWebPagesByKeyWord);

        removePageByUrl("https://faang-school.com/courses/");

        ArrayList<WebPage> testWebPagesByKeyWordAfterRemove = getWebPagesByKeyWord("data");
        testPrintAllPagesByKeyWord(testWebPagesByKeyWordAfterRemove);
        testPrintAllPages();
    }

    public static void indexingNewWebPage(WebPage webPage) {
        String[] keyWords = webPage.getContent().split(" ");
        for (int i = 0; i < keyWords.length; i++) {
            WEB_PAGES.put(keyWords[i], WEB_PAGES.computeIfAbsent(
                    keyWords[i], keyWord -> new ArrayList<>())).add(webPage);
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
