package school.faang.googleminiengine.maincode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WebPageService {
    public static void addWebPage(WebPage webPage, Map<String, List<WebPage>> webPageList) {
        String[] key = webPage.getContext().split("[ ,.!?-]+");
        for (String word : key) {
            webPageList.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> searchWebPage(String keyWord, Map<String, List<WebPage>> webPageList) {
        return webPageList.get(keyWord);
    }

    public static void removeWebPage(String url, Map<String, List<WebPage>> webPageList) {
        for (List<WebPage> page : webPageList.values()) {
            Iterator<WebPage> iterator = page.iterator();
            while(iterator.hasNext()) {
                WebPage webPage = iterator.next();
                if (webPage.getUrl().equals(url)) {
                    iterator.remove();
                }
            }
        }
    }

    public static void printAll(Map<String, List<WebPage>> webPageList) {
        for (Map.Entry<String, List<WebPage>> entry : webPageList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}