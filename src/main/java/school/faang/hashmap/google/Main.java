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

        main.indexNewPage(new WebPage("url1", "Title 1", "word word11 word12 word13 1"));
        main.indexNewPage(new WebPage("url2", "Title 2", "word word21 word22 word33 2"));
        main.indexNewPage(new WebPage("url1", "Title 3", "word word21 word22 word33 3"));

        main.printAll();

        String kWord = "sjh";
        System.out.printf("\n Get List by key word %s. List: %s", kWord, main.getContentByWord(kWord).toString());
        kWord = "word";
        System.out.printf("\n Get List by key word %s. List: %s", kWord, main.getContentByWord(kWord).toString());

        main.deleteContextByUrl("url1");

        main.printAll();
    }

    public void indexNewPage(WebPage webPage) {
        String[] indexWords = webPage.getContent().split(" ");
        Arrays.stream(indexWords).forEach(s -> {
            google.putIfAbsent(s, new ArrayList<>());
            google.get(s).add(webPage);
        });
    }

    public List<WebPage> getContentByWord (String keyWord){
        return google.getOrDefault(keyWord, new ArrayList<>());
    }

    public void deleteContextByUrl(String url) {
        KeyWordAndWebPage keyWordAndWebPage = new KeyWordAndWebPage(null, null);
        while (keyWordAndWebPage != null) {
            keyWordAndWebPage = deleteCalculation(url);
            if (keyWordAndWebPage != null) {
                google.get(keyWordAndWebPage.getKeyWord()).remove(keyWordAndWebPage.getWebPage());
                if(google.get(keyWordAndWebPage.getKeyWord()).isEmpty()) {
                    google.remove(keyWordAndWebPage.getKeyWord());
                }
            }
        }
    }

    private KeyWordAndWebPage deleteCalculation(String url) {
        for(Map.Entry<String, List<WebPage>> mapEntry: google.entrySet()) {
            for (WebPage tempWebPage : mapEntry.getValue()) {
                if(tempWebPage.getUrl().equals(url)) {
                    return new KeyWordAndWebPage(mapEntry.getKey(), tempWebPage);
                }
            }
        }
        return null;
    }

    public void printAll() {
        google.forEach((s, webPages) -> System.out.printf("\nKeyWord: %s === Context : %s", s, webPages.toString()));
    }
}