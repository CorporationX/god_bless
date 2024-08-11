package googleSearch;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private List<String> content;

    public static void indexMap(Map<String , List<WebPage>> pageMap, List<WebPage> pageList) {
        for (WebPage page : pageList) {
            for (int i = 0; i < page.content.size(); i++) {
                String pageContent = page.content.get(i);
                if (!pageMap.containsKey(pageContent)) {
                    List<WebPage> mapList = new ArrayList<>();
                    mapList.add(page);
                    pageMap.put(pageContent,mapList);
                }
                else {
                    pageMap.get(pageContent).add(page);
                }
            }
        }
    }

    public static void outputMap(Map<String , List<WebPage>> pageMap) {
        for (Map.Entry<String, List<WebPage>> pair : pageMap.entrySet()) {
            for (int i = 0; i < pair.getValue().size(); i++) {
                System.out.println(pair.getKey() + " : " + pair.getValue().get(i));
            }
        }
    }

    public static void searchPage(Map<String , List<WebPage>> pageMap, String searchPage) {
        System.out.println(pageMap.get(searchPage));
    }

    public static void removeUrl(Map<String , List<WebPage>> pageMap, String url) {
        for (Map.Entry<String, List<WebPage>> pair : pageMap.entrySet()) {
            for (int i = 0; i < pair.getValue().size(); i++) {
                if(pair.getValue().get(i).url.equals(url)) {
                    pageMap.get(pair.getKey()).remove(new WebPage(pair.getValue().get(i).url,
                                                                  pair.getValue().get(i).title,
                                                                  pair.getValue().get(i).content));
                }
            }
        }
    }
}
