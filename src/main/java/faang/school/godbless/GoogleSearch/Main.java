package faang.school.godbless.GoogleSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static HashMap<String, List<WebPage>> stringListMap = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("//url1", "Гарри Поттер и филосовский камень",
                "Книга про Гарри Поттера и филосовский камень");
        WebPage webPage2 = new WebPage("//url2", "Гарри Поттер и тайная комната",
                "Книга про Гарри Поттера и тайную комнату");
        WebPage webPage3 = new WebPage("//url3", "Гарри Поттер и орден Феникса",
                "Книга про Гарри Поттера и орден Феникса");

        indexNewPage(webPage1);
        indexNewPage(webPage2);
        indexNewPage(webPage3);
        printInfo();

        System.out.println(searchWebPage("камень"));

        deleteWebPage("//url2");
    }


    public static void indexNewPage(WebPage webPage) {
        String[] arrayWords = webPage.getContent().split(" ");
        for (String word : arrayWords) {
            if (word.length() > 2) {
                if (!stringListMap.containsKey(word)) {
                    stringListMap.put(word, new ArrayList<>());
                }
                stringListMap.get(word).add(webPage);
            }
        }
    }

    public static List<WebPage> searchWebPage(String string){
        return stringListMap.get(string);
    }

    public static void deleteWebPage(String url){
        for (Map.Entry<String, List<WebPage>> entry : stringListMap.entrySet()){
            for(WebPage webPage: entry.getValue()){
                if(webPage.getUrl().equals(url)){
                    entry.getValue().remove(webPage);
                    System.out.println("Страница с url " + url + " удалена");
                    return;
                }
            }
        }

    }

    public static void printInfo() {
        for (Map.Entry<String, List<WebPage>> entry : stringListMap.entrySet())
            System.out.println("Ключ: " + entry.getKey() + ", значение: " + entry.getValue());
    }

}
