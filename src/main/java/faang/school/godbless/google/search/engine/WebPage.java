package faang.school.godbless.google.search.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebPage {
    private static final Map<String, List<WebPage>> webPagesSortedList = new HashMap<>();
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
            String[] keywords = webPage.content.split(" ");

            for (String keyword : keywords) {
                keyword = keyword
                        .toLowerCase()
                        .replace(",", "")
                        .replace(".", "");

                if (webPagesSortedList.containsKey(keyword)) {
                    webPagesSortedList.get(keyword).add(webPage);
                } else {
                    webPagesSortedList.put(keyword, new ArrayList<>());
                    webPagesSortedList.get(keyword).add(webPage);
                }
            }
        }

        return webPagesSortedList;
    }

    public static List<WebPage> getWebPageByKeyword(String keyword) {
        List<WebPage> webPagesWithKeyword = new ArrayList<>();

        webPagesSortedList
                .forEach((key, value) -> {
                    key = key.replace(",", "").replace(".", "");
                    if (key.equalsIgnoreCase(keyword)) {
                        webPagesWithKeyword.addAll(value);
                    }
                });

        return webPagesWithKeyword;
    }

    public static void removeWebPageFromIndexByUrl(String url) {
        webPagesSortedList
                .forEach((key, webPageList) -> {
                    for (int i = 0; i < webPageList.size(); i++) {
                        if (webPageList.get(i).url.equals(url)) {
                            webPageList.remove(i);
                        }
                    }
                });
    }
}
