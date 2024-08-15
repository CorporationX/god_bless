package faang.school.godbless.BJS2_20239;

import java.util.*;

public class Main {

    private static final Map<String, List<WebPage>> searcher = new HashMap<>();

    public static void indexingForPage (WebPage page){
        String[] words = page.getContent().split("\\W+");
        for (String word : words){
            searcher.computeIfAbsent(word, value -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> findPages(String keyword){
        return searcher.getOrDefault(keyword, Collections.emptyList());
    }

    public static void removePage(String url){
        for (List<WebPage> pages : searcher.values()){
            pages.removeIf(webpage -> webpage.getUrl().equals(url));
        }
    }

    public static void main(String[] args) {

        WebPage webPage = new WebPage("http://example.com/page1", "First Example", "The creation of flexibility");
        WebPage webPage1 = new WebPage("http://example.com/page2", "Second Example", "The description of flexibility");
        WebPage webPage2 = new WebPage("http://example.com/page3", "Third Example", "The description of durability");

        indexingForPage(webPage);
        indexingForPage(webPage1);
        indexingForPage(webPage2);
        searcher.forEach((key, value) -> System.out.println(key + " - " + value));

        List<WebPage> pages = findPages("description");
        for (WebPage page : pages){
            System.out.println(page);
        }
    }

}
