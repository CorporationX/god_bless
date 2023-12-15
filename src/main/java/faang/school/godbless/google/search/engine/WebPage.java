package faang.school.godbless.google.search.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebPage {
    private static final Map<String, List<WebPage>> webPagesIndexedByContent = new HashMap<>();
    private static final Map<String, List<WebPage>> webPagesIndexedByUrl = new HashMap<>();
    private static final List<WebPage> webPages = new ArrayList<>();
    private String title;
    private String content;
    protected String url;

    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public static Map<String, List<WebPage>> indexWebPages(List<WebPage> webPages) {
        for (WebPage webPage : webPages) {
            Set<String> keywords = new HashSet<>(Set.of(webPage.content.split(" ")));

            for (String keyword : keywords) {
                keyword = setConvertedString(keyword);

                webPagesIndexedByContent.putIfAbsent(keyword, new ArrayList<>());
                webPagesIndexedByContent.get(keyword).add(webPage);
            }
        }

        return webPagesIndexedByContent;
    }

    protected static Map<String, List<WebPage>> indexWebPagesByUrl(List<WebPage> webPages) {
        for (WebPage webPage : webPages) {
            String url = webPage.url;
            webPagesIndexedByUrl.putIfAbsent(url, new ArrayList<>());
            webPagesIndexedByUrl.get(url).add(webPage);
        }

        return webPagesIndexedByUrl;
    }

    public static List<WebPage> getWebPageByKeyword(String keyword) {
        keyword = setConvertedString(keyword);

        if (webPagesIndexedByContent.containsKey(keyword)) {
            List<WebPage> webPagesWithKeyword = webPagesIndexedByContent.get(keyword);
            return webPagesWithKeyword;
        } else {
            return new ArrayList<>();
        }
    }

    public static Map<String, List<WebPage>> removeWebPageFromIndexByUrl(List<WebPage> webPages, String url) {
        if (webPagesIndexedByUrl.keySet().contains(url)) {
            webPagesIndexedByUrl.remove(url);
        }

        System.out.println(webPagesIndexedByUrl.keySet());

        return webPagesIndexedByUrl;
    }

    private static String setConvertedString(String value) {
        value = value.toLowerCase().replace(",", "").replace(".", "");
        return value;
    }
}
