package faang.school.godbless.BJS2_20244;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, LinkedContainer<WebPage>> webPages = new HashMap<>();
    private static Set<WebPage> uniqueWebPages = new HashSet<>();
    private static Map<String, List<Node<WebPage>>> webPageNodes = new HashMap<>();

    public static void main(String[] args) {
        WebPage gypsophilaPage = new WebPage("https://en.wikipedia.org/wiki/Gypsophila", "Gypsophila",
                "Gypsophila is a genus of flowering plants in the carnation family, Caryophyllaceae. " +
                        "They are native to Eurasia, Africa, Australia, and the Pacific Islands.");
        WebPage mapPage = new WebPage("https://www.baeldung.com/java-map-computeifabsent",
                "The Map.computeIfAbsent()", "Furthermore, if the key isn’t present in the map, or the " +
                "null value is related to the key, then it attempts to compute the value using the given " +
                "mappingFunction.");

        addWebPage(gypsophilaPage);
        addWebPage(mapPage);
        System.out.println("Result after adding:");
        System.out.println(gypsophilaPage);
        System.out.println(mapPage);

        var webPages = findWebPages("Eurasia");
        System.out.println("Result after searching:");
        webPages.print();

        deleteWebPage("https://en.wikipedia.org/wiki/Gypsophila");
        System.out.println("Result after delete:");
        for (WebPage webPage : uniqueWebPages) {
            System.out.println(webPage);
        }
    }

    private static void addWebPage(WebPage webPage) {
        if (webPage != null && !uniqueWebPages.contains(webPage)) {
            uniqueWebPages.add(webPage);
            String content = webPage.getContent().replaceAll("\\p{Punct}", "");
            Set<String> words = new LinkedHashSet<>(Arrays.asList(content.split(" ")));
            for (String word : words) {
                webPages.computeIfAbsent(word, page -> new LinkedContainer<>()).addLast(webPage);
                Node<WebPage> webPageNode = webPages.get(word).getLast();
                webPageNodes.computeIfAbsent(webPage.getUrl(), node -> new ArrayList<>()).add(webPageNode);
            }
        }
    }

    private static LinkedContainer<WebPage> findWebPages(String word) {
        return webPages.get(word);
    }

    private static void deleteWebPage(String url) {
        if (!webPageNodes.containsKey(url)) {
            return;
        }
        List<Node<WebPage>> nodes = webPageNodes.get(url);
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        WebPage webPage = nodes.get(0).value;
        String content = webPage.getContent().replaceAll("\\p{Punct}", "");
        Set<String> words = new LinkedHashSet<>(Arrays.asList(content.split(" ")));
        int ind = 0;
        for (String word : words) {
            webPages.get(word).remove(webPageNodes.get(url).get(ind));
            ind++;
        }
        uniqueWebPages.remove(webPage);
        webPageNodes.remove(url);
    }
}
