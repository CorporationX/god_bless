package school.faang.mini_engine_google;

import java.util.*;

public class Main {
    private static Map<String, List<WebPage>> webPageList = new HashMap<>();

    public static void main(String[] args) {
        WebPage firstWebPage = new WebPage("aaa", "sss", "hello world");
        WebPage secondWebPage = new WebPage("bbb", "eee", "hi world");
        WebPage thirdWebPage = new WebPage("ccc", "ttt", "bye world");

        addWebPage(firstWebPage);
        addWebPage(secondWebPage);
        addWebPage(thirdWebPage);

        System.out.println(searchWebPage("hello"));
        System.out.println(searchWebPage("world"));

        removeWebPage("bbb");

        printAll();
    }

    public static void addWebPage(WebPage webPage) {
        String[] key = webPage.getContext().split(" ");
        for (String word : key) {
            webPageList.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> searchWebPage(String keyWord) {
        return webPageList.get(keyWord);
    }

    public static void removeWebPage(String url) {
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

    public static void printAll() {
        for (Map.Entry<String, List<WebPage>> entry : webPageList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
