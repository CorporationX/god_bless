package faang.school.godbless.search_engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<String, List<WebPage>> webPageMap = new HashMap<>();

    public static void main(String[] args) {
        List<WebPage> pageList = new ArrayList<>();
        pageList.add(new WebPage("https://webPage.ru", "title",
                "обязанность по! направлению вышеуказанных, сведений направлению"));
        pageList.add(new WebPage("https://webPage.ru1", "title1",
                "обязанность и направление! сведения"));
        pageList.add(new WebPage("https://webPage.ru2", "title2",
                "по! направлению вышеуказанных, направить"));

        for (WebPage page : pageList) {
            startIndexing(page);
        }

        List<WebPage> webPageList = findPageList("обязанность");
        webPageList.forEach(System.out::println);


        removeWebPage("https://webPage.ru1");

        for (Map.Entry<String, List<WebPage>> entry : webPageMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

    public static void startIndexing(WebPage page) {
        String[] words = page.getContent()
                .trim()
                .replaceAll("\\p{Punct}", "")
                .split(" ");

        for (String word : words) {
            if (!webPageMap.containsKey(word)) {
                webPageMap.computeIfAbsent(word, list -> new ArrayList<>(List.of(page)));
            } else {
                webPageMap.get(word).add(page);
            }
        }
    }

    public static List<WebPage> findPageList(String word) {
        return webPageMap.get(word);
    }

    public static void removeWebPage(String url) {
        Iterator<List<WebPage>> map = webPageMap.values().iterator();
        while (map.hasNext()) {
            List<WebPage> pageList = map.next();
            for (WebPage webPage : pageList) {
                if (webPage.getUrl().equals(url)) {
                    map.remove();
                }
            }
        }
    }
}
