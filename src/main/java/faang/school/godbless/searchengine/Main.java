package faang.school.godbless.searchengine;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, List<WebPage>> webSitesByKeyWords = new HashMap<>();

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 10; i ++){
            string.append("google ");
        }
        WebPage webPageGoogle = new WebPage("https://www.google.com/?client=safari", "Google", string.toString());
        indexing(webPageGoogle);
        System.out.println(searchByKeyWord("google"));
    }

    public static void indexing(WebPage webPage) {
        String[] keyWords = webPage.getContent().replaceAll("\\W", " ").split(" ");
        for (String keyWord : keyWords) {
            if (!webSitesByKeyWords.containsKey(keyWord)) {
                webSitesByKeyWords.put(keyWord, new ArrayList<>());
            }
            if (!webSitesByKeyWords.get(keyWord).contains(webPage)) {
                webSitesByKeyWords.get(keyWord).add(webPage);
            }
        }
    }

    public static List<WebPage> searchByKeyWord(String keyWord) {
        return webSitesByKeyWords.get(keyWord);
    }

    public static void deleteWebPageByURL(String url) {
        for (List<WebPage> listWebPage : webSitesByKeyWords.values()) {
            listWebPage.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
