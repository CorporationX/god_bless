package school.faang.hashmap.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    Map<String, List<WebPage>> google = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();

        main.indexNewPage(new WebPage("url1", "Title 1", "word word11 word12 word133 1"));
        main.indexNewPage(new WebPage("url2", "Title 2", "word word21 word22 word333 2"));
        main.indexNewPage(new WebPage("url1", "Title 3", "word word21 word22 word333 3"));

        main.printAll();

        String kWord = "sjh";
        System.out.printf("\n Get List by key word %s. List: %s", kWord, main.getContentByWord(kWord).toString());
        kWord = "word";
        System.out.printf("\n Get List by key word %s. List: %s", kWord, main.getContentByWord(kWord).toString());

        main.deleteContextByUrl("url1");

        main.printAll();
    }

    public void indexNewPage(WebPage webPage) {
        String[] indexWords = webPage.getContent().toLowerCase().split(" ");
        Arrays.stream(indexWords).forEach(word -> google.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage));
    }

    public List<WebPage> getContentByWord(String keyWord) {
        return google.getOrDefault(keyWord.toLowerCase(), new ArrayList<>());
    }

    public void deleteContextByUrl(String url) {
        List<String> keysToDelete = new ArrayList<>();
        for (Map.Entry<String, List<WebPage>> mapEntry : google.entrySet()) {
            mapEntry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
            if (google.get(mapEntry.getKey()).isEmpty()) {
                keysToDelete.add(mapEntry.getKey());
            }
        }
        keysToDelete.forEach(key -> google.remove(key));
    }

    public void printAll () {
        google.forEach((s, webPages) -> System.out.printf("\nKeyWord: %s === Context : %s", s, webPages.toString()));
    }
}