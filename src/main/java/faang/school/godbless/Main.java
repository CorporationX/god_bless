package src.main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    Map<String, List<WebPage>> map = new HashMap<>();


    void indexNewWebPage(Map<String, List<WebPage>> map, WebPage webPage) {
        String[] words = WebPage.getContent().split("[ ,.:;!?\n\r]+");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.get(word).add(webPage);
            } else {
                List<WebPage> newList = new ArrayList<>();
                newList.add(webPage);
                map.put(word, newList);
                System.out.println(map);
            }
        }
    }
}
