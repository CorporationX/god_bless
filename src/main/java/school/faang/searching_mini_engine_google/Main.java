package school.faang.searching_mini_engine_google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        var webPages = new HashMap<String, List<Webpage>>();
        add(new Webpage("sport.com", "sport", "sport news"), webPages);
        add(new Webpage("sport.com", "hokey", "sport news"), webPages);
        add(new Webpage("politic.com", "politics", "politic information"), webPages);

        System.out.println("Search: " + search("sport", webPages));
        remove("sport", "sport.com", webPages);
        System.out.println("Search: " + search("sport", webPages));
        System.out.println(webPages);

    }

    private static void add(Webpage webpage, Map<String, List<Webpage>> webPages) {
        var content = webpage.content().split(" ");
        for (var word : content) {
            webPages.computeIfAbsent(word, v -> new ArrayList<>()).add(webpage);
        }
    }

    private static List<Webpage> search(String keyword, Map<String, List<Webpage>> webPages) {
        return webPages.get(keyword);
    }

    private static void remove(String index, String url, Map<String, List<Webpage>> webPages) {
        webPages.get(index).removeIf(webpage -> webpage.url().equals(url));
    }
}
