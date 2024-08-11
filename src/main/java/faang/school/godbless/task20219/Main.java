package faang.school.godbless.task20219;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<WebPage>> listOfWebPages = new IdentityHashMap<>();
        WebPage webPage1 = new WebPage("https://habr.com/ru/articles/671344/",
                "Как попробовать ELK-стек за один вечер",
                    " Elasticsearch - хранение и поиск данных); Logstash - конвеер для обработки, фильтрации и нормализации логов; Kibana - интерфейс для удобного поиска и администрирования" );
        WebPage webPage2 = new WebPage("https://habr.com/ru/articles/421179/", "Внутренняя работа HashMap в Java",
                "Хэширование -это процесс преобразования объекта в целочисленную форму, выполняется с помощью метода hashCode().");

        System.out.println(createIndex(webPage2, listOfWebPages));
        removeWebPageByURL("https://habr.com/ru/articles/671344/", listOfWebPages);
        System.out.println(listOfWebPages);
        System.out.println(findPageByWord("преобразования", listOfWebPages));
    }

    public static Map<String, List<WebPage>> createIndex(WebPage webPage, Map<String, List<WebPage>> listOfWebPages){
        List<String> words = List.of(webPage.getContent().replaceAll("[^a-zA-Zа-яА-ЯёЁ ]", "").split("\\\s+"));
            int sizeOfWords = words.size();
            for (int i = 0; i < sizeOfWords; i++) {
            listOfWebPages.computeIfAbsent(words.get(i), k -> new ArrayList<>()).add(webPage);
        }
            return listOfWebPages;
    }

    public static List<WebPage> findPageByWord(String string, Map<String, List<WebPage>> listOfWebPages){
        List<WebPage> webPageList = listOfWebPages.get(string);
        return webPageList;
    }
    
    public static void removeWebPageByURL(String url, Map<String, List<WebPage>> listOfWebPages){
        for (Map.Entry<String, List<WebPage>> entry : listOfWebPages.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
