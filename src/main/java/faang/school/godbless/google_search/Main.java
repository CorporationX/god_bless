package faang.school.godbless.google_search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<WebPage>> webPageMap = new HashMap<>();

        WebPage webPage1 = new WebPage("youtube.com", "SomeYouTuber",
                "hello, chanel!?? subscribe +-*/:^;,.!?@#$%&(){}[]`~'\"\\\\\\");
        WebPage webPage2 = new WebPage("someshop.org", "SomeItem", "buy!!! subscribe,,. HELLO");

        WebPage.addToIndex(webPageMap, webPage1);
        WebPage.addToIndex(webPageMap, webPage2);
        showWebPage(webPageMap);
        System.out.println();

        List<WebPage> webPageList = WebPage.searchWebPages(webPageMap, "Hello");
        for(WebPage webPage : webPageList){
            System.out.println(webPage);
        }
        System.out.println();

        WebPage.deleteWebPageByUrl(webPageMap, "youtube.com");
        showWebPage(webPageMap);
    }

    public static void showWebPage(Map<String, List<WebPage>> webPageMap){
        for(Map.Entry<String, List<WebPage>> webPageEntry : webPageMap.entrySet()){
            System.out.println(webPageEntry.getKey() + " keyWord!");
            for(WebPage webPage : webPageEntry.getValue()){
                System.out.println(webPage);
            }
        }
    }
}
