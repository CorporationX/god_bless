package faang.school.godbless.googleengine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> WEB_PAGES = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Add 3 pages");
        addWebPage(new WebPage("habr.com", "habr", "IT, cars, engine"));
        addWebPage(new WebPage("stackoverflow.com", "stackoverflow", "IT, java, python, String, Integer"));
        addWebPage(new WebPage("codewars.com", "codawars", "java, python, String, Integer, submit"));
        printAllPages();
        System.out.println("----------------");
        System.out.println();

        System.out.println("find page by IT");
        findWebPages("IT").forEach(System.out::println);
        System.out.println("----------------");
        System.out.println();

        System.out.println("remove page by url codewars.com");
        removeWebPage("codewars.com");
        printAllPages();
    }

    public static void addWebPage(WebPage webPage) {
        for (String word : webPage.getContent().split(" ")) {
            String keyWord = word.replaceAll("\\p{Punct}", "");
            WEB_PAGES.computeIfAbsent(keyWord.trim(), key -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPages(String keyWord) {
        return WEB_PAGES.get(keyWord);
    }

    public static void removeWebPage(String url) {
        WebPage webPageToRemove = WEB_PAGES.values().stream()
                .flatMap(Collection::stream)
                .filter(webPage -> url.equals(webPage.getUrl()))
                .findAny().orElse(null);

        if (webPageToRemove == null) {
            throw new IllegalArgumentException("This URL is missing from index");
        }

        for (List<WebPage> list : WEB_PAGES.values()) {
            if (list.contains(webPageToRemove)) {
                list.remove(webPageToRemove);
            }
        }
    }

    public static void printAllPages() {
        for (Map.Entry<String, List<WebPage>> entry : WEB_PAGES.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }
}
