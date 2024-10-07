package school.faang.google_search_engine_BJS2_32733;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<WebPage>> index = new HashMap<>();

    public static void main(String[] args) {
        WebPage page1 = new WebPage(
                "https://www.example.com", "Example Domain",
                "This domain is For use in illustrative examples in documents.");

        WebPage page2 = new WebPage(
                "https://www.wikipedia.org", "Wikipedia",
                "Wikipedia is a free online encyclopedia, created and edited by volunteers around the world .");

        WebPage page3 = new WebPage(
                "https://www.github.com", "GitHub",
                "GitHub is a code hosting platform for version control and collaboration.");

        WebPage page4 = new WebPage(
                "https://www.stackoverflow.com", "Stack Overflow",
                "Stack Overflow is a question and answer site for professional and enthusiast programmers.");

        WebPage page5 = new WebPage(
                "https://www.webPage.com", "Online Page",
                "This   page   has   lots   of   spaces");

        addPageToIndex(page5);
        System.out.println(index + "\n");
        addPageToIndex(page1);
        addPageToIndex(page2);
        addPageToIndex(page3);
        addPageToIndex(page4);
        System.out.println(findPagesByKeyWord("for"));
        System.out.println(findPagesByKeyWord("and"));
        deletePageFromIndexByUrl("https://www.wikipedia.org");
        System.out.println(index);
    }

    public static void addPageToIndex(WebPage page) {
        Set<String> keyWords = new HashSet<>(List.of(page.getContent().toLowerCase().split("\\s+")));
        for (String keyWord : keyWords) {
            index.computeIfAbsent(keyWord, k -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> findPagesByKeyWord(String keyword) {
        return index.get(keyword);
    }

    public static void deletePageFromIndexByUrl(String url) {
        index.entrySet().removeIf(entry -> entry.getValue().stream()
                .anyMatch(webPage -> webPage.getUrl().equals(url)));
    }

}


