package faang.school.godbless.task14;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://github.com", "Github", "qwerty something code eat sleap repeat");
        WebPage webPage2 = new WebPage("https://gitlab.com", "Gitlab", "code eat sleap repeat");
        WebPage webPage3 = new WebPage("https://docker.com", "Docker", "qwerty something");
        addWebPage(webPage1);
        addWebPage(webPage2);
        addWebPage(webPage3);
        System.out.println(getPagesByWord("code"));
        deleteWebPageByUrl("https://gitlab.com");
    }
    public static Map<String, List<WebPage>> webPages = new HashMap<>();;
    private static final Set<WebPage> index = new HashSet<>();

    public static void addWebPage(WebPage webPage) {
        index.add(webPage);
        String[] words = webPage.getContent().split(" ");
        Set<String> uniqueWords = Set.of(words);
        for (String word: uniqueWords) {
            webPages.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }

    }

    public static List<WebPage> getPagesByWord(String word) {
        return webPages.get(word);
    }

    public static void deleteWebPageByUrl(@NonNull String url) {
        for (WebPage webPage : index) {
            if (webPage.getUrl().equals(url)) {
                index.remove(webPage);
                return;
            }
        }


    }
}
