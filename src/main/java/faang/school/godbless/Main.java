package faang.school.godbless;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<WebPage>> webPagesByKeyword = new HashMap<>();
    private static final List<WebPage> allWebPages = new ArrayList<>();

    public static void main(String[] args) {
        indexation(new WebPage("https://github.com/", "GitHub", "GitHub is a popular web-based" +
                " platform where developers can store, manage, and collaborate on their code." +
                " It offers version control, issue tracking, and project management tools" +
                " to help teams work together more effectively"));

        System.out.println(getAllWebPagesByKeyword("GitHub"));
        System.out.println("-----------------------------");
        System.out.println(webPagesByKeyword);
        deleteWebPageByUrl("https://github.com/");
        System.out.println("-----------------------------");
        System.out.println(allWebPages);
    }

    public static void indexation(@NonNull WebPage page) {
        allWebPages.add(page);

        List<String> allKeywords = Arrays.stream(page.getContent().replaceAll("\\p{Punct}", "")
                .split(" ")).toList();

        for (String keyword : allKeywords) {
            if (webPagesByKeyword.containsKey(keyword)) {
                webPagesByKeyword.get(keyword).add(page);
            } else {
                List<WebPage> webPages = new ArrayList<>();
                webPages.add(page);
                webPagesByKeyword.put(keyword, webPages);
            }
        }
    }

    public static List<WebPage> getAllWebPagesByKeyword(@NonNull String keyword) {
        if (webPagesByKeyword.containsKey(keyword)) {
            return webPagesByKeyword.get(keyword);
        } else {
            throw new RuntimeException("No web pages found for keyword: " + keyword);
        }
    }

    public static void deleteWebPageByUrl(@NonNull String url) {
        for (WebPage webPage : allWebPages) {
            if (webPage.getUrl().equals(url)) {
                allWebPages.remove(webPage);
                return;
            }
        }
        throw new RuntimeException("No web pages found for url: " + url);
    }
}