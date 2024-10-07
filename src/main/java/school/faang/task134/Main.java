package school.faang.task134;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WebPage firstWebPage = new WebPage("https://habr.com/ru/articles/345520/", "Шпаргалки Java", "test, words! check method efficiency ");
        WebPage secondWebPage = new WebPage("https://trychatgpt.ru/#rec589416386", "ChatGPT на русском", "her might be some words from web page");
        WebPage thirdWebPage = new WebPage("https://leetcode.com/", "LeetCode main title", "some important words from leetCode");


        WebPageService.indexNewWebPage(firstWebPage);
        WebPageService.indexNewWebPage(secondWebPage);
        WebPageService.indexNewWebPage(thirdWebPage);

        WebPageService.printAll();
        System.out.println();

        System.out.println(WebPageService.findWebPage("words"));
        WebPageService.removeByUrl("https://leetcode.com/");
        System.out.println();

        WebPageService.printAll();
    }
}
