package faang.school.godbless.beksultan2005;

import lombok.Getter;

import java.util.*;

@Getter
public class Main {
    private static Map<String, List<WebPage>> webPages = new HashMap<>();
    private static Map<String, List<String>> urlIndex = new HashMap<>();

    public static void addWord(WebPage webPage) {
        String[] words = webPage.getContent().split("\\W+");
        for (String word : words) {
            webPages.computeIfAbsent(word.toLowerCase(), w -> new ArrayList<>()).add(webPage);
            urlIndex.computeIfAbsent(webPage.getUrl(), w -> new ArrayList<>()).add(word.toLowerCase());
        }
    }

    public static List<WebPage> getWebPageByWord(String string) {
        String[] words = string.split("\\W+");
        List<WebPage> webPages = new ArrayList<>();
        for (String word : words) {
            List<WebPage> pages = Main.webPages.get(word.toLowerCase());
            if (pages != null) {
                webPages.addAll(pages);
            }
        }
        return webPages;
    }

    public static void removeWebPage(String url) {
        List<String> words = urlIndex.remove(url);
        if (words != null) {
            for (String word : words) {
                List<WebPage> pages = webPages.get(word);
                if (pages != null) {
                    pages.removeIf(webPage -> Objects.equals(webPage.getUrl(), url));
                    if (pages.isEmpty()) {
                        webPages.remove(word);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        WebPage page1 = new WebPage("http://example.com", "Example Page 1", "This is the content of the first example page.");
        WebPage page2 = new WebPage("http://example.org", "Example Page 2", "This is another example page with different content.");

        addWord(page1);
        addWord(page2);

        getWebPageByWord("example").forEach(key -> System.out.println(key.toString()));

        removeWebPage("http://example.org");

        getWebPageByWord("example").forEach(key -> System.out.println(key.toString()));
    }
}
