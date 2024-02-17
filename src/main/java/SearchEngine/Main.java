package SearchEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WebPage {
    private String url;
    private String title;
    private String content;

    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

public class Main {
    private static Map<String, List<WebPage>> index = new HashMap<>();

    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\s+");

        for (String word : words) {
            index.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> searchByKeyword(String keyword) {
        return index.getOrDefault(keyword, new ArrayList<>());
    }

    public static void removeWebPage(String url) {
        index.values().forEach(webPages -> webPages.removeIf(webPage -> webPage.getUrl().equals(url)));
    }

    public static void main(String[] args) {
        WebPage page1 = new WebPage("http://example.com/page1", "Page 1", "Java programming is fun");
        WebPage page2 = new WebPage("http://example.com/page2", "Page 2", "Java is widely used in web development");
        WebPage page3 = new WebPage("http://example.com/page3", "Page 3", "Web development with Java Spring framework");
        WebPage page4 = new WebPage("http://example.com/page4", "Page 4", "С++++++++++++++++++++");

        indexWebPage(page1);
        indexWebPage(page2);
        indexWebPage(page3);
        indexWebPage(page4);

        System.out.println("Web pages containing 'Java': " + searchByKeyword("Java"));

        removeWebPage("http://example.com/page2");

        System.out.println("Web pages containing 'Java' after removal: " + searchByKeyword("Java"));
    }
}
