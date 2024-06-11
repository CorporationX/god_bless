package faang.school.godbless.HashMaps.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<WebPage>> indexWordWebPages = new HashMap<>();
    private static final Set<WebPage> uniqueWebPages = new HashSet<>();
    private static final Map<String, List<String>> indexUrlWords = new HashMap<>();

    public static void main(String[] args) {
        addIndexWebPage(new WebPage("webpage1", "title1", "java collection framework list"));
        addIndexWebPage(new WebPage("webpage2", "title2", "list ArrayList LinkedList"));
        addIndexWebPage(new WebPage("webpage3", "title3", "Map HashMap Entry Key Value"));

        System.out.println(indexWordWebPages);
        System.out.println(getWebPages("list"));

        removeWebPage("webpage3");
        System.out.println(indexWordWebPages);

    }

    public static void addIndexWebPage(WebPage webPage) {
        if (!uniqueWebPages.contains(webPage)) {
            String[] content = webPage.content().split(" ");
            Set<String> uniqueWordContent = new HashSet<>(Set.of(content));
            for (String word : uniqueWordContent) {
                if (indexWordWebPages.containsKey(word)) {
                    indexWordWebPages.get(word).add(webPage);
                } else {
                    indexWordWebPages.put(word, new ArrayList<>(List.of(webPage)));
                }
                uniqueWebPages.add(webPage);
            }

            indexUrlWords.put(webPage.url(), new ArrayList<>(List.of(content)));
        }
    }

    public static List<WebPage> getWebPages(String keyWord) {
        return indexWordWebPages.get(keyWord);
    }

    public static void removeWebPage(String url) {
        List<String> words = indexUrlWords.remove(url);
        WebPage urlWebPage = new WebPage(url);
        for (String word : words) {
            indexWordWebPages.get(word).remove(urlWebPage);

            if(indexWordWebPages.get(word).isEmpty()) {
                indexWordWebPages.remove(word);
            }
        }
        
        uniqueWebPages.remove(urlWebPage);
    }
}
