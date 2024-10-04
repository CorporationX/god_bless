package school.faang.t08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    HashMap<String, List<WebPage>> index = new HashMap<>();

    public void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split("\\s+");
        for (String word : words) {
            index.putIfAbsent(word, new ArrayList<>());
            if (!index.get(word).contains(webPage)) {
                index.get(word).add(webPage);
            }
        }
    }

    public List<WebPage> searchByKeyword(String keyword) {
        return index.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    public void removeWebPage(String url) {
        for (List<WebPage> pages : index.values()) {
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }

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
}

