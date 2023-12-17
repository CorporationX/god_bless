package GoogleEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webPagesByKeywords = new HashMap<>();

    public static void main(String[] args) {

        Main.indexPage(new WebPage("url1", "title1", "body head content"));
        Main.indexPage(new WebPage("url2", "title2", "public static void"));
        Main.indexPage(new WebPage("url3", "title3", "string array list"));
        Main.indexPage(new WebPage("url4", "title4", "public static void"));

        Main.findPageByKeyword("body");
        Main.findPageByKeyword("static");

        Main.findPageByKeyword("asdf");

        Main.removePageByURL("url2");
        System.out.println(webPagesByKeywords);

        Main.removePageByURL("url3");
        System.out.println(webPagesByKeywords);
    }

    public static void indexPage(WebPage webPage) {
        //Разбить содержание страницы на отдельные ключевые слова
        List<String> keywords = webPage.getKeywords(webPage);

        //По каждому слову создать/получить List из страниц
        List<WebPage> tempWebPages;
        for (String keyword : keywords) {
            tempWebPages = webPagesByKeywords.getOrDefault(keyword, new ArrayList<>());
            tempWebPages.add(webPage);
            webPagesByKeywords.put(keyword, tempWebPages);
        }
    }

    public static void findPageByKeyword(String keyword) {
        System.out.println(keyword);
        System.out.println(webPagesByKeywords.get(keyword));
    }

    public static void removePageByURL(String url) {
        //Создадим временное хранилище вебстраниц для цикла
        List<WebPage> tempListOfPages;
        //Пройдемся по каждому элементу мапы
        for (Map.Entry<String, List<WebPage>> entry : webPagesByKeywords.entrySet()) {
            tempListOfPages = entry.getValue();
            //Пройдемся по каждому элементу листа в мапе
            //Если url вебстраницы совпал - удаляем его
            tempListOfPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
