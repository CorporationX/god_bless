package school.faang.t08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static final HashMap<String, List<WebPage>> INDEX = new HashMap<>();

    public static void main(String[] args) {
        Main method = new Main();

        WebPage one = new WebPage("http://example.com/1", "Жираф", "Фиолетовый жираф танцевал под звёздным небом");
        WebPage two = new WebPage("http://example.com/2", "Компьютер", "Квантовый компьютер и жираф решили сложную математическую задачу");
        WebPage three = new WebPage("http://example.com/3", "Бабочка", "Бабочка-махаон порхала среди ярких экзотических цветов");

        method.indexWebPage(one);
        method.indexWebPage(two);
        method.indexWebPage(three);

        System.out.println(method.searchByKeyword("жираф"));
        method.removeWebPage("http://example.com/3");
    }


    public void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split("\\s+");
        for (String word : words) {
            INDEX.putIfAbsent(word, new ArrayList<>());
            if (!INDEX.get(word).contains(webPage)) {
                INDEX.get(word).add(webPage);
            }
        }
    }

    public List<WebPage> searchByKeyword(String keyword) {
        return INDEX.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    public void removeWebPage(String url) {
        for (List<WebPage> pages : INDEX.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }
}