package faang.school.godbless.googleEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Map<String, List<WebPage>> INDEXED_PAGES = new HashMap<>();

    public static void main(String[] args) {
        WebPage firstPage = WebPage.builder()
                .url("https://page.com")
                .title("first page")
                .content("Hello hello")
                .build();

        WebPage secondPage = WebPage.builder()
                .url("https://page2.com")
                .title("second page")
                .content("Hello man")
                .build();

        WebPage thirdPage = WebPage.builder()
                .url("https://page3.com")
                .title("third page")
                .content("Hi you")
                .build();

        indexPage(firstPage);
        indexPage(secondPage);
        indexPage(thirdPage);
        List<WebPage> you = getPagesByWord("you");

        System.out.println("result by word: " + you);

        deletePageByUrl("https://page.com");
    }

    public static void indexPage(WebPage page) {

        if (page != null && page.getContent() != null) {
            String content = page.getContent();
            List<String> splitedContent = Arrays.asList(content.toLowerCase().split("\\s+|,|-"));

            for (String word : splitedContent) {
                INDEXED_PAGES.merge(word, new ArrayList<>(List.of(page)), (oldValue, newPage) -> {
                    oldValue.addAll(newPage);

                    return oldValue;
                });
            }
        }
    }

    public static List<WebPage> getPagesByWord(String page) {
        if (page == null) {
            return null;
        }

        return INDEXED_PAGES.get(page);
    }

    public static void deletePageByUrl(String url) {
        if (url != null) {
            Set<Map.Entry<String, List<WebPage>>> entries = INDEXED_PAGES.entrySet();

            for (Map.Entry<String, List<WebPage>> entry : entries) {
                List<WebPage> pages = entry.getValue();

                pages.removeIf(page -> page.getUrl().equals(url));
            }
        }
    }
}
