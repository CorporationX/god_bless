package school.faang.googlesearchengine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WebPageIndex webPageIndex = new WebPageIndex();
        WebPage webPage1 = new WebPage("http://example.com/page1", "Example Page 1", "This is the content of example page one.");
        WebPage webPage2 = new WebPage("http://example.com/page2", "Example Page 2", "Content of the second example page.");
        WebPage webPage3 = new WebPage("http://example.com/page3", "Example Page 3", "This page is about example topics.");

        webPageIndex.indexNewPage(webPage1);
        webPageIndex.indexNewPage(webPage2);
        webPageIndex.indexNewPage(webPage3);

        String searchKey = "example";
        List<WebPage> foundPages = webPageIndex.webPageByKeyword(searchKey);
        System.out.println("Страница содержит " + searchKey + " :");
        for (WebPage webPage : foundPages){
            System.out.println("Заголовок "+ webPage.getTitle()+ ", URL: " +webPage.getUrl()+ webPage.getContent());
        }

        webPageIndex.removeWebPage("http://example.com/page2");

        foundPages =webPageIndex.webPageByKeyword("example");
        System.out.println("Страница содержащие disk после удаление");
        for (WebPage webPage : foundPages){
            System.out.println("Заголовок " + webPage.getTitle()+ ", URL: "+ webPage.getUrl());
        }
    }
}
