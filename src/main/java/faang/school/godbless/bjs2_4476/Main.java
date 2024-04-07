package faang.school.godbless.bjs2_4476;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@Slf4j
public class Main {

    private static final Map<String, Set<WebPage>> webPageMap = new HashMap<>();
    private static final String CONTENT1 = "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, " +
            "разработанный компанией Sun Microsystems. Разработка ведётся сообществом, организованным через Java Community Process; " +
            "язык и основные реализующие его технологии распространяются по лицензии GPL";
    private static final String CONTENT2 = "Приложения Java обычно транслируются в специальный байт-код, поэтому они могут работать на любой компьютерной архитектуре";

    public static void main(String[] args) {
        WebPage page = new WebPage("http://test.page", "Test page", CONTENT1);
        WebPage page2 = new WebPage("http://test2.page", "Test page 2", CONTENT2);
        indexWebPage(page);
        indexWebPage(page2);
        getPagesByKeyWord("Java").forEach(System.out::println);
        removePageByUrl("http://test2.page");
        getPagesByKeyWord("Java").forEach(System.out::println);
        getPagesByKeyWord("Python");
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
        Set<WebPage> foundPages = webPageMap.get(keyWord);
        if (foundPages == null) {
            log.info("Pages by key word: '{}' not found!", keyWord);
            throw new NoSuchElementException("Pages by key word: '" + keyWord + "' not found!");
        }
        return foundPages;
    }

    public static void removePageByUrl(String url) {
        log.info("Remove page: '{}' from index", url);
        webPageMap.values().forEach(set -> set.removeIf(page -> page.getUrl().equals(url)));
    }
}
