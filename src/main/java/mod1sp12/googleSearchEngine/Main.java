package mod1sp12.googleSearchEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<WebPage>> INDEX_WEBPAGES = new HashMap<>();
    private static final Map<String, Set<String>> INDEX_WORDS_BY_URLS = new HashMap<>();
    private static final Map<String, WebPage> INDEX_WEBPAGE_BY_URLS = new HashMap<>();

    private static void indexingWebPages(WebPage webPage) {
        Set<String> uniqueWords = new HashSet<>();
        List<String> cleanedWords = new ArrayList<>();
        String[] contentWords = webPage.getContent().split(" ");

        for (String contentWord : contentWords) {
            contentWord = contentWord.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();
            cleanedWords.add(contentWord);
            if (uniqueWords.add(contentWord)) {
                INDEX_WEBPAGES.computeIfAbsent(contentWord, key -> new ArrayList<>()).add(webPage);
            }
        }
        INDEX_WORDS_BY_URLS.computeIfAbsent(webPage.getUrl(), key -> new HashSet<>()).addAll(cleanedWords);
        INDEX_WEBPAGE_BY_URLS.put(webPage.getUrl(), webPage);
    }

    private static List<WebPage> getListWebPagesWitchContainWord(String word) {
        if (INDEX_WEBPAGES.get(word) == null) {
            System.out.println("A web page containing word was not found: " + word);
        }
        return INDEX_WEBPAGES.get(word);
    }

    private static void removeWebPageFromIndexByUrl(String webPageUrl) {
        Set<String> wordsContainedByUrl = INDEX_WORDS_BY_URLS.get(webPageUrl);
        if (wordsContainedByUrl != null) {
            for (String word : wordsContainedByUrl) {
                INDEX_WEBPAGES.get(word).remove(INDEX_WEBPAGE_BY_URLS.get(webPageUrl));
                if (INDEX_WEBPAGES.get(word).isEmpty()) {
                    INDEX_WEBPAGES.remove(word);
                }
            }
        }
    }

    public static void main(String[] args) {
        indexingWebPages(new WebPage("https://faang-school.com/courses/", "FAANG SCHOOL", "Мы сделаем " +
                "из тебя java разработчика"));
        indexingWebPages(new WebPage("https://ya.ru/", "Яндекс - быстрый поиск в интернете",
                "url java, малосолка фильмы, сортировка пузырьком, как стать java разработчиком"));
        indexingWebPages(new WebPage("https://www.google.com/", "Google", "java разработчики скоро " +
                "будут не нужны! Все пишут микросервисы на Pascal"));
        indexingWebPages(new WebPage("https://calendar.google.com/calendar/", "Google Calendar", "Pascal " +
                "собеседование на позицию Senior Pascal developer "));
        indexingWebPages(new WebPage("https://miro.com/app/board/", "Miro", "Для решения задачи Google " +
                "search я для начала найду все слова по отдельности, а потом буду добавлять их в индекс, через computeIf" +
                "Absent"));

        for (Map.Entry<String, List<WebPage>> webPages : INDEX_WEBPAGES.entrySet()) {
            System.out.println(webPages.getKey() + ": " + webPages.getValue());
        }

        System.out.println();
        for (Map.Entry<String, Set<String>> webPages : INDEX_WORDS_BY_URLS.entrySet()) {
            System.out.println(webPages.getKey() + ": " + webPages.getValue());
        }

        removeWebPageFromIndexByUrl("https://ya.ru/");
        removeWebPageFromIndexByUrl("https://www.google.com/");
        removeWebPageFromIndexByUrl("https://calendar.google.com/calendar/");
        removeWebPageFromIndexByUrl("https://miro.com/app/board/");

        System.out.println();
        for (Map.Entry<String, List<WebPage>> webPages : INDEX_WEBPAGES.entrySet()) {
            System.out.println(webPages.getKey() + ": " + webPages.getValue());
        }

        System.out.println();
        System.out.println(getListWebPagesWitchContainWord("java"));
        System.out.println(getListWebPagesWitchContainWord("randomWord"));
    }
}
