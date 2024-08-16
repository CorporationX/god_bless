package faang.school.godbless.Maps.BJS2_20254;


import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static Map<String, List<WebPage>> webPageList = new HashMap<>();

    public static void main(String[] args) {

        WebPage webPageAmrood = new WebPage("https://www.amrood.com");
        WebPage webPageGoogel = new WebPage("https://www.google.com");

        indexWebPage(webPageAmrood);
        indexWebPage(webPageGoogel);
        System.out.println(webPageList);
        remove(webPageAmrood.getUrl());
//        remove(webPage2.getUrl());
        System.out.println(search("Good"));
        System.out.println(webPageList);
    }

    public static void indexWebPage(WebPage webPage) {
        String[] strings = webPage.getContent().split("\\W+");
        for (String str : strings) {
            webPageList.computeIfAbsent(str, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> search(String string) {
        return webPageList.get(string);
    }

    public static void remove(String url) {
        for (Map.Entry<String, List<WebPage>> webPageEntry : webPageList.entrySet()) {
            List<WebPage> pages = webPageEntry.getValue();
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}
