package faang.school.godbless.beksultan2005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> cacheWebPage = new HashMap<>();

    public static void addWord(WebPage webPage){
        String[] words = webPage.getContent().split("\\W+");
        for(String word : words){
            cacheWebPage.computeIfAbsent(word.toLowerCase(), w -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> getWebPageByWord(String string){
        String[] words = string.split("\\W+");
        List<WebPage> webPages = new ArrayList<>();
        for(String word : words){
            List<WebPage> pages = cacheWebPage.get(word.toLowerCase());
            if (pages != null) {
                webPages.addAll(pages);
            }
        }
        return webPages;
    }

    public static void main(String[] args) {
        WebPage page1 = new WebPage("http://example.com", "Example Page 1", "This is the content of the first example page.");
        WebPage page2 = new WebPage("http://example.org", "Example Page 2", "This is another example page with different content.");

        addWord(page1);
        addWord(page2);

        List<WebPage> result = getWebPageByWord("example");
        System.out.println("Pages containing the word 'example':");
        for (WebPage page : result) {
            System.out.println(page.getUrl() + " - " + page.getTitle());
        }
    }
}
