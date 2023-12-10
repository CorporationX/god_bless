package faang.school.godbless.task5;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@EqualsAndHashCode
@ToString
public class Main {
    private static Map<String, List<WebPage>> indexPage = new HashMap<>();

    public static void methodIndex (WebPage webPage) {
        String[] contextSplit = webPage.getContent().split(" ");
        for (String word : contextSplit) {
            List<WebPage> webPagesList = indexPage.getOrDefault(word, new ArrayList<>());
            webPagesList.add(webPage);
            indexPage.put(word, webPagesList);
        }
    }

    public static List<WebPage> searchWebPage(String search) {
        if (indexPage.containsKey(search)) {
            return indexPage.get(search);
        } else {
            return new ArrayList<WebPage>();
        }
    }

    public static void removeWebPage(String url) {
        for (List<WebPage> page : indexPage.values()) {
            for (int i = 0; i < page.size(); i++) {
                if (page.get(i).getUrl().equalsIgnoreCase(url)) {
                    page.remove(i);
                    i--;
                }
            }
        }
    }

    public static void main(String[] args) {
        WebPage faang = new WebPage("www.faang-school.com", "faang school", "Java HashMap: Поисковый мини-движок Google");
        WebPage google = new WebPage("www.google.com", "google search", "Google Maps, Google disk");
        WebPage yandex = new WebPage("www.yandex.ru", "yandex plus", "Yandex music, yandex drive");

        methodIndex(faang);
        methodIndex(google);
        methodIndex(yandex);

        System.out.println(searchWebPage("music"));
        removeWebPage("yandex");
    }
}

@Data
@AllArgsConstructor
class WebPage {
    private String url;
    private String title;
    private String content;
}
