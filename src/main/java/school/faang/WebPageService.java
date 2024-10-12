package school.faang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebPageService {
    public static void writeIndexToMap(WebPage webPage, Map<String, List<WebPage>> webPagesWithKey,
                                       Set<WebPage> pages) {
        if (!(pages.contains(webPage))) {
            pages.add(webPage);
            String[] indexSet = webPage.getContent().split(" ");
            for (String index : indexSet) {
                if (!webPagesWithKey.containsKey(index)) {
                    webPagesWithKey.putIfAbsent(index, new ArrayList<>());
                    List<WebPage> webPageList = webPagesWithKey.get(index);
                    webPageList.add(webPage);
                } else {
                    List<WebPage> webPageList = webPagesWithKey.get(index);
                    webPageList.add(webPage);
                }
            }
        }
    }

    public static void viewWebPagesByIndex(String index, Map<String, List<WebPage>> webPagesWithKey) {
        System.out.println(index + ": " + webPagesWithKey.get(index).toString());
    }

    public static void removeWebPageByUrl(String url, Map<String, List<WebPage>> webPagesWithKey) {
        for (Map.Entry<String, List<WebPage>> pair : webPagesWithKey.entrySet()) {
            List<WebPage> studentList = pair.getValue();
            Iterator<WebPage> iterator = studentList.iterator();
            while (iterator.hasNext()) {
                WebPage webPage1 = iterator.next();
                if (webPage1.getUrl().equals(url)) {
                    iterator.remove();
                }
            }
        }
    }
}
