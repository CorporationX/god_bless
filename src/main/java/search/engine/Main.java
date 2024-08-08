package search.engine;

import lombok.Getter;
import lombok.NonNull;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @Getter
    private static final Map<String, List<WebPage>> indexMap = new HashMap<>();
    @Getter
    private static final Map<URL, List<String>> pageContentMap = new HashMap<>();

    public static void main(String[] args) {
        try {
            URL url1 = new URI("http://baeldung.com").toURL();
            URL url2 = new URI("http://google.com").toURL();
            URL url3 = new URI("http://github.com").toURL();
            URL url4 = new URI("http://youtube.com").toURL();
            WebPage webPage1 = new WebPage(url1, "baeldung", "java, spring, learn");
            WebPage webPage2 = new WebPage(url2, "google", "learn, search");
            WebPage webPage3 = new WebPage(url3, "github", "java, search, repository");
            WebPage webPage4 = new WebPage(url4, "youtube", "");
            addPageToIndex(webPage1);
            addPageToIndex(webPage2);
            addPageToIndex(webPage3);
            printIndex();
            System.out.println();
            getPagesByKeyWord("java").forEach(System.out::println);
            System.out.println();
            getPagesByKeyWord("learn").forEach(System.out::println);
            System.out.println();
            getPagesByKeyWord("search").forEach(System.out::println);
            System.out.println();
            getPagesByKeyWord("spring").forEach(System.out::println);
            System.out.println();
            getPagesByKeyWord("repository").forEach(System.out::println);
            getPagesByKeyWord("test");
            removeFromIndexByURL(url2);
            printIndex();
            System.out.println();
            getPagesByKeyWord("search").forEach(System.out::println);
            System.out.println();
            getPagesByKeyWord("learn").forEach(System.out::println);
            removeFromIndexByURL(new URI("http://yandex.ru").toURL());
            printIndex();
            addPageToIndex(webPage4);
            printIndex();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Illegal url address");
        }
    }

    public static void addPageToIndex(@NonNull WebPage webPage) {
        if (webPage.getContent().isEmpty()) {
            System.out.println("\nCan't add to index, content of page is empty");
        } else {
            String[] words = webPage.getContent().split("\\W+");
            pageContentMap.put(webPage.getUrl(), Arrays.stream(words).toList());
            for (String word : words) {
                indexMap.computeIfAbsent(word, v -> new ArrayList<>()).add(webPage);
            }
            System.out.println("\nPage is added to index");
        }
    }

    public static List<WebPage> getPagesByKeyWord(@NonNull String keyWord) {
        List<WebPage> listOfPages = null;
        if (indexMap.containsKey(keyWord)) {
            listOfPages = indexMap.get(keyWord);
        } else {
            System.out.println("\nDon't have this keyword in index");
        }
        return listOfPages;
    }

    public static void removeFromIndexByURL(@NonNull URL url) {
        if (pageContentMap.containsKey(url)) {
            WebPage page = new WebPage(url, "", "");
            for (String keyWord : pageContentMap.get(url)) {
                indexMap.get(keyWord).remove(page);
                if (indexMap.get(keyWord).isEmpty()) {
                    indexMap.remove(keyWord);
                }
            }
        } else {
            System.out.println("\nPage with this url not in index");
        }
    }

    public static void printIndex() {
        System.out.println();
        for (Map.Entry<String, List<WebPage>> entry : indexMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            entry.getValue().forEach(page -> System.out.println("    " + page));
        }
    }
}
