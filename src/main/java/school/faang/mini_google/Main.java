package school.faang.mini_google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static final Map<String, List<WebPage>> WEB_PAGE_INDEX = new HashMap<>();

    public static void main(String[] args) {
        WebPage cats = new WebPage("www.cats.ru", "cats", "cats Are cute");
        WebPage dogs = new WebPage("www.dogs.ru", "dogs", "and dogs are cool");
        WebPage pets = new WebPage("www.pets.ru", "pets", "both dogs and cats - great");
        addWebPage(cats);
        addWebPage(dogs);
        addWebPage(pets);
        System.out.println(WEB_PAGE_INDEX);
        System.out.println(findWebPageByKeyWord("cats"));
        deleteWebPageByUrl("www.cats.ru");
        System.out.println(WEB_PAGE_INDEX);
    }

    public static void addWebPage(WebPage webPage) {
        String content = webPage.getContent();
        Set<String> keywords = Arrays.stream(content.split("[,;\\s.-]+"))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        for (String keyword : keywords) {
            WEB_PAGE_INDEX.computeIfAbsent(keyword, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPageByKeyWord(String keyword) {
        keyword = keyword.toLowerCase();
        return WEB_PAGE_INDEX.get(keyword);
    }

    public static void deleteWebPageByUrl(String url) {
        for (List<WebPage> webPages : WEB_PAGE_INDEX.values()) {
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
        WEB_PAGE_INDEX.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }
}