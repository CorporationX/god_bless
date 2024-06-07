package faang.school.godbless.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<WebPage>> webPages = new HashMap<>();

    public static void main(String[] args) {
        webPages.put("Java", new ArrayList<>());
        webPages.put("Google", new ArrayList<>());
        addNewWebPage(new WebPage("java.com", "Java", "Get Java for desktop applications"));
        addNewWebPage(new WebPage("google.com", "google", "Google, you can find all search for."));
        System.out.println(findByKeyWord("Java"));
        System.out.println(findByKeyWord("Google"));
        deleteByUrl("google.com");
        System.out.println(findByKeyWord("Google"));
    }

    public static void addNewWebPage(WebPage webPage) {
        Set<String> sortedContent = new HashSet<>(Arrays.asList(webPage.getContent().trim().split("\\s+|,\\s*|\\.\\s*")));
        for (String sortedWord : sortedContent) {
            webPages.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findByKeyWord(String keyWord) {
        return webPages.get(keyWord);
    }

    public static void deleteByUrl(String url) {
        webPages.forEach((type, webPagesList) -> webPagesList.removeIf(webPage -> webPage.getUrl().equals(url)));
    }

}
