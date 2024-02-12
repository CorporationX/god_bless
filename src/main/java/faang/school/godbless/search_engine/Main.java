package faang.school.godbless.search_engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {

    private static final Map<String, List<WebPage>> index = new HashMap<>();

    public static void main(String[] args) throws Exception {
        WebPage page1 = new WebPage( "https://wiki.com/page1", "Page 1", "Page wiki1" );
        WebPage page2 = new WebPage( "https://wiki.com/page2", "Page 2", "content of wiki2" );

        indexWebPage( page1 );
        indexWebPage( page2 );

        List<WebPage> searchResult = findWebPagesByKeyWord( "content" );
        System.out.println( "Pages containing 'content': " );

        for (WebPage page : searchResult) {
            System.out.println( "    URL: " + page.getUrl() );
            System.out.println( "    Title: " + page.getTitle() );
        }

        deleteWebPageByUrl("https://example.com/page2" );
        System.out.println( "***********************" );
        index.forEach( (k, v) -> System.out.println( k + " " + v ) );

    }


    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split( "\\s+" );
        for (String word : words) {
            word = word.toLowerCase();
            List<WebPage> pages = index.getOrDefault( word, new ArrayList<>() );
            pages.add( webPage );
            index.put( word, pages );
        }
    }

    public static List<WebPage> findWebPagesByKeyWord(String keyWord) throws Exception {
        List<WebPage> pages = index.get( keyWord.toLowerCase() );
        if (pages == null) {
            throw new Exception( "No pages exist with given key word" );
        } else if (pages.size() == 0) {
            System.out.println( "There is 0 pages for such key word" );
            return pages;
        } else {
            return pages;
        }
    }

    public static void deleteWebPageByUrl(String url) {
        for (List<WebPage> pages : index.values()) {
            for(WebPage webPage : pages) {
                if (webPage.getUrl().equals( url )) {
                    pages.remove( webPage );
                }
            }
        }
    }
}
