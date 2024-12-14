package faang.school.godbless.BJS2_20360;

import java.util.*;

public class Main {
    private static final Map<String, List<WebPage>> INDEXER = new HashMap<>();

    public static void main(String[] args) {

        addToIndex(new WebPage("https://google.com", "Google", "Welcome to the Google site!"));
        addToIndex(new WebPage("https://yandex.ru", "Yandex", "Welcome to the Yandex site!"));
        addToIndex(new WebPage("https://yahoo.ru", "Yanhoo", "Welcome to the Yahoo site!"));
        addToIndex(new WebPage("https://Finder.ru", "Finder", "The Finder!"));
        addToIndex(new WebPage("https://Test.ru", "Test", "The test "));

        System.out.println(INDEXER);

        System.out.println(findPages("test"));
        System.out.println(findPages("Yandex"));
        System.out.println(findPages("Welcome"));

        removeFromIndex("https://google.com");
        System.out.println(INDEXER);
        System.out.println(findPages("Google"));

        removeFromIndex("https://Test.ru");
        System.out.println(INDEXER);
        System.out.println(findPages("test"));

        removeFromIndex("https://Nothing.ru");
        System.out.println(INDEXER);
        System.out.println(findPages("nothing"));
    }

    private static void addToIndex(WebPage webPage) {
        String[] content = webPage.getContent().split(" ");
        Arrays.stream(content)
                .forEach(word -> {
                    if (!INDEXER.containsKey(word) || !INDEXER.get(word).contains(webPage)) {
                        INDEXER.put(word, new ArrayList<>(List.of(webPage)));
                    } else {
                     //   if (!INDEXER.get(word).contains(webPage))
                            INDEXER.get(word).add(webPage);
                    }
                });
    }

    static List<WebPage> findPages(String word) {
        return INDEXER.get(word);
    }

    static void removeFromIndex(String url) {
        int removingIndex = -1;
        boolean isExist = false;
        for (Map.Entry<String, List<WebPage>> entry : INDEXER.entrySet()) {
            for (WebPage webPage : entry.getValue()) {
                if (Objects.equals(url, webPage.getUrl())) {
                    removingIndex = entry.getValue().indexOf(webPage);
                    isExist = true;
                }
            }
            if (removingIndex != -1) {
                entry.getValue().remove(removingIndex);
                removingIndex = -1;
            }
        }

        if (!isExist)
            System.out.println("Не найдено ни одного сайта с url = " + url);
    }
}
