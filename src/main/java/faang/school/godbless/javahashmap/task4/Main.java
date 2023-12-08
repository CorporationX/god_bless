package faang.school.godbless.javahashmap.task4;

import lombok.Data;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Main {
    private static Map<String, List<WebPage>> indexWebPages = new HashMap<>();
    private static List<WebPage> listWebPage = new ArrayList<>();

    public static void main(String... args) {
        initListWebPage();

        addIndexWebPage(listWebPage.get(0));
        addIndexWebPage(listWebPage.get(1));
        addIndexWebPage(listWebPage.get(2));

        removeIndexWebPage("несущуствующий url");
        removeIndexWebPage("https://example.com/page3");

        System.out.println(returnIndexWebPage("web") + "\n");

        infoIndexWebPage("https://example.com/page2");
    }
    public static void initListWebPage() {
        WebPage page1 = new WebPage();
        page1.setUrl("https://example.com/page1");
        page1.setTitle("Page 1 Title");
        page1.setContent("Эта web страница содержит интересную информацию о программировании.");

        WebPage page2 = new WebPage();
        page2.setUrl("https://example.com/page2");
        page2.setTitle("Page 2 Title");
        page2.setContent("На этой web страницe вы найдете полезные советы по обучению новым технологиям.");

        WebPage page3 = new WebPage();
        page3.setUrl("https://example.com/page3");
        page3.setTitle("Page 3 Title");
        page3.setContent("Содержание данной страницы посвящено последним тенденциям в мире информационных технологий.");

        listWebPage.add(page1);
        listWebPage.add(page2);
        listWebPage.add(page3);

        System.out.println("Веб-страницы созданы\n");
    }

    public static void addIndexWebPage(WebPage webPage) {
        String content = webPage.getContent();

        List<String> keyWords = Arrays.stream(content.toLowerCase().split("\\s+"))
                .map(x -> x.replaceAll("[^a-zA-Zа-яА-Я]", "")).distinct().toList();

        for (String keyWord: keyWords) {
            if (!indexWebPages.containsKey(keyWord)) {
                indexWebPages.put(keyWord, new ArrayList<>());
            }

            indexWebPages.get(keyWord).add(webPage);
        }

        System.out.println("В индекс была добавлена станица " + webPage.getTitle() + "\n");
    }

    public static List<WebPage> returnIndexWebPage(String keyWord) {
        return indexWebPages.get(keyWord);
    }

    public static void removeIndexWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> entry: indexWebPages.entrySet()) {
            for (WebPage webPage: entry.getValue()) {
                if (webPage.getUrl().equals(url)) {
                    entry.getValue().remove(webPage);
                    System.out.println("Была удалена страница с url: " + url + "\n");
                    return;
                }
            }
        }

        System.out.println("Не найдена страница с url: " + url + "\n");
    }

    public static void infoIndexWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> entry: indexWebPages.entrySet()) {
            for (WebPage webPage: entry.getValue()) {
                if (webPage.getUrl().equals(url)) {
                    System.out.println("info  --------------------------------------------------------------------------------");
                    System.out.println("url: " + url);
                    System.out.println("Название: " + webPage.getTitle());
                    System.out.println("Содержание: " + webPage.getContent());
                    System.out.println("-----------------------------------------------------------------------------------------");
                    return;
                }
            }
        }

        System.out.println("Не найдена страница с url: " + url + "\n");
    }


}
