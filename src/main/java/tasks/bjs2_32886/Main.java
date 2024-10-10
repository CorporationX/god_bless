package tasks.bjs2_32886;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, List<WebPage>> pagesIndexes = new HashMap<>();

    public static void main(String[] args) {
        showAllPageIndexes();
        generateWebPages();
        showAllPageIndexes();
        showPagesByIndex("ЭтО");
        showPagesByIndex("hfjdhfjdhfj");
        removeWebPageByURL("https://www.google.ru");
        showPagesByIndex("https://www.google.ru");
        showAllPageIndexes();
    }

    private static void generateWebPages() {
        addPage(
            "ht://www.youtube.com",
            "YouTube — Видео платформа",
            "YouTube — это крупнейшая платформа для просмотра и загрузки видео."
        );
        addPage(
            "https://www.youtube.com",
            "",
            "YouTube — это крупнейшая платформа для просмотра и загрузки видео."
        );
        addPage(
            "https://www.youtube.com",
            "YouTube — Видео платформа",
            " "
        );
        addPage(
            "https://www.google.ru",
            "Поисковая система Google",
            "Google — это мощная поисковая система, которая помогает находить информацию в Интернете."
        );

        addPage(
            "https://www.vk.com",
            "Социальная сеть ВКонтакте",
            "ВКонтакте — это популярная социальная сеть, где можно общаться и делиться новостями."
        );

        addPage(
            "https://www.mail.ru",
            "Mail.ru — Электронная почта",
            "Mail.ru предоставляет почтовый сервис и много других полезных инструментов."
        );
    }

    private static void showAllPageIndexes() {
        System.out.println("Показать все слова индексы :");

        if (pagesIndexes.size() == 0) {
            System.out.println("Нету ни одного индекса \n");
            return;
        }

        pagesIndexes.keySet().forEach(System.out::println);
        System.out.println();
    }


    private static void addPage(String url, String title, String content) {
        System.out.println("Пытаемся добавить вэб страницу " + title);

        try {
            WebPage page = WebPage.createValidated(url, title, content);

            indexingWebPageData(page, page.getUrl(), page.getTitle(), page.getContent());
            System.out.println("Страница добавлена и проиндексированна");
        } catch (Exception e) {
            System.out.println("Не удалось добавить вэб страницу по причине : " + e.getMessage());
        }

        System.out.println();
    }

    private static void indexingWebPageData(WebPage page, String... data) {
        GetIndexes(data).forEach(
            word -> pagesIndexes.computeIfAbsent(word.toLowerCase(), k -> new ArrayList<>()).add(page)
        );
    }

    private static void showPagesByIndex(String word) {
        word = word.toLowerCase();
        System.out.println("Показать вэб страницы содержимое которого содержит слово : " + word);

        if (!pagesIndexes.containsKey(word)) {
            System.out.println("Нету вэб страниц содержимое которого содержит слово : " + word + "\n");
            return;
        }

        pagesIndexes.get(word).stream().forEach(System.out::println);
        System.out.println();
    }

    private static void removeWebPageByURL(String url) {
        System.out.println("Пытаемся удалить вэб страницу по url " + url);

        if (pagesIndexes.isEmpty()) {
            System.out.println("Нет ни одной добавленной вэб страницы" + "\n");
            return;
        }

        if (!pagesIndexes.containsKey(url)) {
            System.out.println("Нету вэб страницы проиндексированной по url : " + url + "\n");
            return;
        }

        WebPage page = pagesIndexes
            .get(url)
            .stream()
            .findFirst()
            .get();
        deindexingWebPageData(page, page.getUrl(), page.getTitle(), page.getContent());
        System.out.println("Страница удалена и деиндексированна");
    }

    private static void deindexingWebPageData(WebPage page, String... data) {
        GetIndexes(data).forEach(word -> {
                List<WebPage> pages = pagesIndexes.get(word);
                pages.remove(page);
                if (pages.isEmpty()) {
                    pagesIndexes.remove(word);
                }
            }
        );
    }

    private static Set<String> GetIndexes(String... data) {
        Set<String> words = new HashSet<>();

        for (String param : data) {
            words.addAll(Arrays.asList(param.toLowerCase().split(" ")));
        }

        return words;
    }
}
