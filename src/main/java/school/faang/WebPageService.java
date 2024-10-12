package school.faang;

import java.util.ArrayList;
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
}
