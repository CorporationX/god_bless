package searchengine;

import static searchengine.WebPageService.getWebPagesByKeyword;
import static searchengine.WebPageService.indexTheWebPage;
import static searchengine.WebPageService.removeWebPageByUrl;

public class Main {


    public static void main(String[] args) {
        indexTheWebPage(new WebPage("url1", "title1", "hello, world!"));
        indexTheWebPage(new WebPage("url1", "title1", "hello, world!"));
        indexTheWebPage(new WebPage("url2", "title2", "hello, again!"));

        System.out.println(getWebPagesByKeyword("hello"));
        System.out.println(getWebPagesByKeyword("world"));
        System.out.println(getWebPagesByKeyword("again"));

        removeWebPageByUrl("url1");
        System.out.println(getWebPagesByKeyword("hello"));
        System.out.println(getWebPagesByKeyword("world"));

        indexTheWebPage(new WebPage("url1", "title1", "hello, world!"));
        System.out.println(getWebPagesByKeyword("hello"));
        System.out.println(getWebPagesByKeyword("world"));
    }
}
