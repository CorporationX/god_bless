package school.faang.minienginegoogle.main;

import school.faang.minienginegoogle.maincode.WebPage;
import school.faang.minienginegoogle.maincode.WebPageService;

import java.util.*;

public class Main {
    private static Map<String, List<WebPage>> webPageList = new HashMap<>();

    public static void main(String[] args) {
        WebPage firstWebPage = new WebPage("aaa", "sss", "hello world");
        WebPage secondWebPage = new WebPage("bbb", "eee", "hi world");
        WebPage thirdWebPage = new WebPage("ccc", "ttt", "bye world");

        WebPageService.addWebPage(firstWebPage, webPageList);
        WebPageService.addWebPage(secondWebPage, webPageList);
        WebPageService.addWebPage(thirdWebPage, webPageList);

        System.out.println(WebPageService.searchWebPage("hello", webPageList));
        System.out.println(WebPageService.searchWebPage("world", webPageList));

        WebPageService.removeWebPage("bbb", webPageList);

        WebPageService.printAll(webPageList);
    }
}