package faang.school.godbless.bjs2_4476;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Map<String, Set<WebPage>> webPageMap = new HashMap<>();

    public static void main(String[] args) {
        String content = "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, " +
                "разработанный компанией Sun Microsystems. Разработка ведётся сообществом, организованным через Java Community Process; " +
                "язык и основные реализующие его технологии распространяются по лицензии GPL";
        String content2 = "Приложения Java обычно транслируются в специальный байт-код, поэтому они могут работать на любой компьютерной архитектуре";
        WebPage page = new WebPage("http://test.page", "Test page", content);
        WebPage page2 = new WebPage("http://test2.page", "Test page 2", content2);
        indexWebPage(page);
        indexWebPage(page2);
        getPagesByKeyWord("Java").forEach(System.out::println);

        System.out.println("\nRemove test2.page from index");
        removePageByUrl("http://test2.page");
        getPagesByKeyWord("Java").forEach(System.out::println);
    }

    public static void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split(" ");
        for (String word : words) {
            word = word.replaceAll("\\p{Punct}", "").trim();
            if (word.length() > 1) {
                webPageMap.computeIfAbsent(word, key -> new HashSet<>()).add(webPage);
            }
        }
    }

    public static Set<WebPage> getPagesByKeyWord(String keyWord) {
        return webPageMap.get(keyWord);
    }

    public static void removePageByUrl(String url) {
        webPageMap.values().forEach(set -> set.removeIf(page -> page.getUrl().equals(url)));
    }
}
