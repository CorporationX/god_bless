package school.faang.task134;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashMap<String, List<WebPage>> INDEX = new HashMap<>();

    public void indexNewWebPage(WebPage webPage) {
        String[] words = webPage.getContent()
                .replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "")
                .toLowerCase()
                .split("\\s");
        for (String word : words) {
            INDEX.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public List<WebPage> findWebPage(String word) {
        return INDEX.get(word.toLowerCase());
    }

    public void removeByUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : INDEX.entrySet()) {
            entry.getValue().removeIf(webPage -> (webPage.getUrl().equals(url)));
        }
    }

    public static void main(String[] args) {
        WebPage firstWebPage = new WebPage("https://habr.com/ru/articles/345520/", "Шпаргалки Java", "test, words! check method efficiency ");
        WebPage secondWebPage = new WebPage("https://trychatgpt.ru/#rec589416386", "ChatGPT на русском", "her might be some words from web page");
        WebPage thirdWebPage = new WebPage("https://leetcode.com/", "LeetCode main title", "some important words from leetCode");

        Main main = new Main();
        main.indexNewWebPage(firstWebPage);
        main.indexNewWebPage(secondWebPage);
        main.indexNewWebPage(thirdWebPage);

        for (Map.Entry<String, List<WebPage>> entry : INDEX.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();

        System.out.println(main.findWebPage("words"));
        main.removeByUrl("https://leetcode.com/");
        System.out.println();

        for (Map.Entry<String, List<WebPage>> entry : INDEX.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
