package bjs2_32797;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static Set<WebPage> indexedPages = new HashSet<>();
    public static Map<String, NodeList<WebPage>> index = new HashMap<>();
    public static Map<String, WebPageIndex> urlIndex = new HashMap<>();

    public static void main(String[] args) {
        WebPage page1 = new WebPage("url1", "title1", "word1 word2");
        WebPage page2 = new WebPage("url2", "title2", "word1 word1");
        WebPage page3 = new WebPage("url3", "title3", "word2 word3");
        WebPage page4 = new WebPage("url4", "title4", "word1 word3");
        WebPage page5 = new WebPage("url5", "title5", "word1 word3 word2");

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

        WebPageIndex wpi = new WebPageIndex(page);
        urlIndex.put(page.getUrl(), wpi);

        Set<String> keywords = new HashSet<>();
        for (String word : page.getContent().split(" ")) {
            if (keywords.contains(word)) {
                continue;
            }
            keywords.add(word);

            Node<WebPage> node = new Node(page);
            wpi.getList().add(node);

            index.putIfAbsent(word, new NodeList<>());
            index.get(word).add(node);
        }
    }

    public static Optional<List<WebPage>> findByWord(String keyword) {
        if (index.containsKey(keyword)) {
            return Optional.of(index.get(keyword).toList());
        }
        return Optional.empty();
    }

    public static void deletePage(String url) {
        if (urlIndex.containsKey(url)) {
            WebPageIndex wpi = urlIndex.get(url);
            List<Node<WebPage>> list = urlIndex.get(url).getList();
            String[] keywords = wpi.getPage().getContent().split(" ");

            for (int i = 0; i < keywords.length; i++) {
                index.get(keywords[i]).remove(list.get(i));
            }

            urlIndex.remove(url);
        }
    }
}
