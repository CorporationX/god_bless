package faang.school.godbless.GoogleSearchEngine2070;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<String, List<WebPage>> webPages = new HashMap<>();

    public static void main(String[] args) {
        WebPage test1 = new WebPage("123", "!!!", "Как дела че делаешь");
        WebPage test2 = new WebPage("1234", "!@!", "Как дела");
        WebPage test3 = new WebPage("1231", "!@!@!", "че делаешь");
        WebPage test4 = new WebPage("1237", "!)(!()!", "дела че");
        addWebPage(test1);
        addWebPage(test2);
        addWebPage(test3);
        addWebPage(test4);
        System.out.println(webPages);
        removeWebPageByUrl("1234");
        System.out.println(webPages);
    }

    public static void addWebPage(WebPage webPage) {
        String[] keyWords = webPage.getContent().split(" ");
        for (String word : keyWords) {
            if (!webPages.containsKey(word)) {
                webPages.put(word, new ArrayList<>());
            }
            if (!webPages.get(word).contains(webPage)) {
                webPages.get(word).add(webPage);
            }
        }
    }

    public static List<WebPage> getWebPagesByKeyword(String keyWord) {
        return webPages.get(keyWord);
    }

    public static void removeWebPageByUrl(String url) {
        for (List<WebPage> webPageList : webPages.values()) {
            webPageList.removeIf((webPage) -> webPage.getUrl().equals(url));
        }
    }
}