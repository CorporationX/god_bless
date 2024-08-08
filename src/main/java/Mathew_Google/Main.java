package Mathew_Google;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class Main {
    private static Map<String, List<WebPage>> webPages = new HashMap<>();

    public static void addWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\s+");
        for (String word : words) {
            if (webPages.containsKey(word)) {
                webPages.get(word).add(webPage);
                System.out.println("Добавлена в существующий список страница: " + webPage.getTitle());
            } else {
                List<WebPage> pages = new ArrayList<>();
                pages.add(webPage);
                webPages.put(word, pages);
                System.out.println("Добавлен новый список со страницей: " + webPage.getTitle());

            }
        }
    }

    public static List<WebPage> searchWebPage(String word) {
        System.out.println("Список страниц выведен на экран");
        for (WebPage webPage : webPages.get(word)) {
            System.out.println(webPage.getTitle());
        }
        return webPages.get(word);
    }

    public static void removeWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : webPages.entrySet()) {
            for (WebPage webPage : entry.getValue()) {
                if (webPage.getUrl().contains(url)) {
                    System.out.println("Страница удалена по url:" + webPage.getTitle());
                    entry.getValue().remove(webPage);
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        WebPage page1 = new WebPage("http://Uber.com/page1", "Page 1", "У нас самые лучшие таксисты");
        WebPage page2 = new WebPage("http://Google.com/page2", "Page 2", "Нами пользуется весь мир");
        WebPage page3 = new WebPage("http://Yandex.com/page3", "Page 3", "Нами пользуется весь СНГ");
        WebPage page4 = new WebPage("http://Amazon.com/page4", "Page 4", "У нас заказывают все страны");
        WebPage page5 = new WebPage("http://PetrSu.com/page5", "Page 5", "Здесь учат 5 лет на учителя");
        WebPage page6 = new WebPage("http://Jut.com/page6", "Page 6", "Сайт для просмотра аниме на Русском");
        WebPage page7 = new WebPage("http://USA.com/page7", "Page 7", "Это страна где 50 штатов");
        WebPage page8 = new WebPage("http://RUSSIA.com/page8", "Page 8", "Это страна где много лесов");
        WebPage page9 = new WebPage("http://Spar.com/page9", "Page 9", "Это очень дорогой Европейский супермаркет");
        WebPage page10 = new WebPage("http://SpaceX.com/page10", "Page 10", "Тут Маск выкладывает фотки с марса");
        addWebPage(page1);
        addWebPage(page2);
        addWebPage(page3);
        addWebPage(page4);
        addWebPage(page5);
        addWebPage(page6);
        addWebPage(page7);
        addWebPage(page8);
        addWebPage(page9);
        addWebPage(page10);
        searchWebPage("страна");
        removeWebPage("http://Uber.com/page1");
    }
}
