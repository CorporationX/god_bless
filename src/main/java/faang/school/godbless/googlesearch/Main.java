package faang.school.godbless.googlesearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        WebPageService webPageService = new WebPageService();
        Map<String, Set<WebPage>> webPagesMap = new HashMap<>();

        webPageService.addWebPage(webPagesMap, new WebPage("yandex.ru", "Yandex", "music, marketplace, search"));
        webPageService.addWebPage(webPagesMap, new WebPage("twitch.tv", "Twitch", "stream, game"));
        webPageService.addWebPage(webPagesMap, new WebPage("youtube.com", "Youtube", "video, stream, game"));

        webPageService.webPagesInfo(webPagesMap);
        System.out.println();

        var searchResult = webPageService.findPagesByKeyWord(webPagesMap, "stream");
        System.out.println(searchResult);

        webPageService.findPagesByKeyWord(webPagesMap, "123");
        System.out.println();

        webPageService.removePageByUrl(webPagesMap, "youtube.com");

        webPageService.webPagesInfo(webPagesMap);
    }
}
