package bjs2_32797;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static Set<WebPage> indexedPages = new HashSet<>();
    public static Map<String, List<WebPage>> index = new HashMap<>();
    public static Map<String, WebPage> urlIndex = new HashMap<>();
    public static String delimiters = "[ ,;:_-]";

    public static void main(String[] args) {
        WebPage page1 = new WebPage("url1", "title1", "word1 word2");
        WebPage page2 = new WebPage("url2", "title2", "word1-word1");
        WebPage page3 = new WebPage("url3", "title3", "word2_word3");
        WebPage page4 = new WebPage("url4", "title4", "word1;word3");
        WebPage page5 = new WebPage("url5", "title5", "word1,word3:word2");

        addWebPage(page1);
        addWebPage(page2);
        addWebPage(page3);
        addWebPage(page4);
        addWebPage(page5);

        System.out.println(index);
        System.out.println("==========================");
        System.out.println(findByWord("word1"));
        System.out.println("==========================");
        deletePage("url4");
        System.out.println(index);
    }

    public static void addWebPage(WebPage page) {
        if (indexedPages.contains(page)) {
            return;
        }
        indexedPages.add(page);
        urlIndex.put(page.getUrl(), page);

        Set<String> keywords = new HashSet<>();
        for (String word : page.getContent().split(delimiters)) {
            if (keywords.contains(word)) {
                continue;
            }
            keywords.add(word);

            index.putIfAbsent(word, new ArrayList<>());
            index.get(word).add(page);
        }
    }

    public static Optional<List<WebPage>> findByWord(String keyword) {
        return Optional.ofNullable(index.get(keyword));
    }

    public static void deletePage(String url) {
        if (urlIndex.containsKey(url)) {
            WebPage page = urlIndex.get(url);
            String[] keywords = page.getContent().split(delimiters);

            for (String keyword : keywords) {
                index.get(keyword).remove(page);
            }

            urlIndex.remove(url);
        }
    }
}
