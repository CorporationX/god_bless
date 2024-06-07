package faang.school.godbless.google_search;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("youtube.com", "SomeYouTuber",
                "hello, chanel!?? subscribe +-*/:^;,.!?@#$%&(){}[]`~'\"\\\\\\");
        WebPage webPage2 = new WebPage("someshop.org", "SomeItem", "buy!!! subscribe,,. HELLO 10kkSUBS");

        Browser google = new Browser();

        google.addToIndex(webPage1);
        google.addToIndex(webPage2);
        google.showWebPages();
        System.out.println();

        List<WebPage> webPageList = google.searchWebPages("Hello");
        for (WebPage webPage : webPageList) {
            System.out.println(webPage);
        }
        System.out.println();

        google.deleteWebPageByUrl("youtube.com");
        google.showWebPages();
    }
}
