package faang.school.godbless.task_14_miniGoogle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> wordPagesMap = new HashMap<>();

    public static void main(String[] args) {
        WebPage googlePage = new WebPage("www.google.com", "Google", "Google Сhrome поиск браузер почта");
        WebPage yandexPage = new WebPage("www.yandex.ru", "Yandex", "Yandex музыка Алиса умная колонка браузер поиск почта");
        WebPage faangPage = new WebPage("www.faangschool.com", "FaangSchool", "faangschool курсы java буткемп Влад Мишустин поиск оффера");

        indexWebPage(yandexPage);
        indexWebPage(googlePage);
        indexWebPage(faangPage);

        // 17 ключей должно быть
        System.out.println("количество ключевых слов: " + wordPagesMap.size()); // 17
        System.out.println();

        // Поиск сайтов в хэше по ключевому слову
        System.out.println("ищем сайты с \"почта\"");
        searchWebPages("почта").forEach(System.out::println);
        System.out.println("\nищем сайты с \"Влад\"");
        searchWebPages("Влад").forEach(System.out::println);
        System.out.println("\nищем сайты с \"поиск\"");
        searchWebPages("поиск").forEach(System.out::println);
        System.out.println();

        // Удаление сайта из хэша
        System.out.println("Удаляем url \"www.google.com\"");
        removeWebPage("www.google.com");
        System.out.println();

        // Вывод ключей и связанного с ними списка сайтов
        System.out.println("Вывод связок слово-сайт");
        showKeyWordWebPages();
        System.out.println();

        // 15 должно быть
        System.out.println("количество ключевых слов после удаления: " + wordPagesMap.size()); // 15
    }

    private static void showKeyWordWebPages() {
        for (var e : wordPagesMap.entrySet()) {
            System.out.println(e.getKey());

            for (WebPage webPage : e.getValue()) {
                System.out.println(webPage);
            }

        }
    }

    /**
     * Каждое слова(длиннее 3 символов символов) в контенте сайта добавляет как ключевое слово в хэш,
     * связывая его с URL сайта.
     * Если слово в хэше уже существует, то URL добавляем в список других сайтов.
     *
     * @param webPage
     */
    public static void indexWebPage(WebPage webPage) {
        List<String> words = Arrays.stream(webPage.content().split(" "))
                .filter(w -> w.length() > 3)
                .map(String::toLowerCase).toList();

        for (String word : words) {
            if (!wordPagesMap.containsKey(word)) {
                wordPagesMap.put(word, new ArrayList<>(List.of(webPage)));
            } else {
                List<WebPage> pages = wordPagesMap.get(word);
                if (!pages.contains(webPage)) {
                    pages.add(webPage);
                }
            }
        }
    }

    /**
     * Находит все WebPage связанные с ключевым словом
     *
     * @param searchWord
     * @return
     */
    public static List<WebPage> searchWebPages(String searchWord) {
        return wordPagesMap.get(searchWord.toLowerCase());
    }

    /**
     * Удаляем из хэша связи ключевых слов с сайтом переданного URL
     *
     * @param url
     */
    public static void removeWebPage(String url) {
        Iterator<Map.Entry<String, List<WebPage>>> entryIterator = wordPagesMap.entrySet().iterator();

        // перебираем связки слово-сайт
        while (entryIterator.hasNext()) {
            List<WebPage> pages = entryIterator.next().getValue();
            Iterator<WebPage> iterator = pages.iterator();

            // перебираем список сайтов связанными с ключевым словом
            while (iterator.hasNext()) {
                WebPage page = iterator.next();

                // если URL совпали, то удаляем сайт из списка
                if (page.url().equals(url)) {
                    iterator.remove();

                    // если это была единственная связь, то удаляем и ключевое слово из хэша
                    if (pages.size() == 0) {
                        entryIterator.remove();
                    }
                }
            }
        }
    }

}
