package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private static final Map<String, List<WebPage>> WEB_LIST_KEY_WORD = new HashMap<>();
    private static final Map<String, WebPage> WEB_LIST_KEY_URL = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("God Bless!");

        WebPage firstWebPage = new WebPage("http.first", "wiki", "day of puple postrg");
        WebPage secondWebPage = new WebPage("https.second", "chatgpt", "Hello world, me name is Vasia");
        WebPage thirdWebPage = new WebPage("www.cite", "barashki", "me mee Me Mee");
        WebPage fourthWebPage = new WebPage("org.basik", "basik", "Puple of name");

        addWebPage(firstWebPage);
        addWebPage(secondWebPage);
        addWebPage(thirdWebPage);
        addWebPage(fourthWebPage);

        removeWebPage("www.cite");

        System.out.println(getListWebPage("me"));
    }

    public static void addWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\s+");

        for (String word : words) {
            if (WEB_LIST_KEY_WORD.containsKey(word)) {
                WEB_LIST_KEY_WORD.get(word).add(webPage);
            } else {
                WEB_LIST_KEY_WORD.put(word, new ArrayList<>());
                WEB_LIST_KEY_WORD.get(word).add(webPage);
            }
        }

        WEB_LIST_KEY_URL.put(webPage.getUrl(), webPage);
    }

    public static List<WebPage> getListWebPage(String keyWord) {
        return WEB_LIST_KEY_WORD.get(keyWord);
    }

    public static void removeWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> pair : WEB_LIST_KEY_WORD.entrySet()) {
            if (pair.getValue().contains(WEB_LIST_KEY_URL.get(url))) {
                WEB_LIST_KEY_WORD.get(pair.getValue().remove(WEB_LIST_KEY_URL.get(url)));
            }
        }
        WEB_LIST_KEY_URL.remove(url);
    }
}