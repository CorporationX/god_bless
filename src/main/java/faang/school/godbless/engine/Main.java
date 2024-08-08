package faang.school.godbless.engine;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, List<WebPage>> indexes;

    private static void indexingWebPage(WebPage page) {
        Set<String> words = Set.of(page.getContent().split("\\p{P}?[\\t\\n\\r\\s]+"));
        //разделение строки по знакам препинания и пробелам
        for (String word : words){
            indexes.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    public static List<WebPage> searchPages(String word) {
        return indexes.get(word);
    }

    public static void deletePage(URL url){
        for (Map.Entry<String, List<WebPage>> pair: indexes.entrySet()){
            for (WebPage page: pair.getValue()){
                if (page.getUrl().equals(url)){
                    pair.getValue().remove(page);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        indexes = new HashMap<>(Map.ofEntries(
                Map.entry("faang", new ArrayList<>(Arrays.asList(
                        new WebPage(new URL("https://faang-school.com/courses/4jnzmndg/xjd77jbd"),"hello1", "faang school is good")
                ))),
                Map.entry("karamba", new ArrayList<>(Arrays.asList(
                        new WebPage(new URL("https://faang-school.com/courses/4jnzmndg"),"hello2", "karamba, svistat vseh naverh!")
                ))),
                Map.entry("baumanka", new ArrayList<>(Arrays.asList(
                        new WebPage(new URL("https://faang-school.com"),"hello3",
                                "I study at baumanka and taking a course from faang")
                )))
        ));

        WebPage newPage1 = new WebPage(new URL("https://stackoverflow.com/questions"), "hello4", "faang, baumanka, karamba, monkey");
        indexingWebPage(newPage1);
        deletePage(new URL("https://faang-school.com/courses/4jnzmndg"));
        List<WebPage> pages = searchPages("faang");
    }
}
