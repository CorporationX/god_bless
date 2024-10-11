package school.faang.JavaHashMap.BJS2_32758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<String, List<WebPage>> index = new HashMap<>();

    public static void main(String[] args) {
        indexUrl(new WebPage(
                "https://javaprogramming.com/basics",
                "Основы программирования на Java",
                "Java — это популярный язык программирования, широко используемый для создания " +
                        "кроссплатформенных приложений. Он имеет строгую типизацию и объектно-ориентированную структуру, " +
                        "ООП"
        ));

        indexUrl(new WebPage(
                "https://javadevelopment.org/web-intro",
                "Введение в веб-разработку на Java",
                "Веб-разработка на Java включает использование таких технологий, как JSP, сервлеты и Spring. " +
                        "Java широко применяется для создания серверных решений."
        ));

        indexUrl(new WebPage(
                "https://oopjava.net/oop-basics",
                "Основы объектно-ориентированного программирования в Java",
                "Объектно-ориентированное программирование ООП базируется на понятиях объектов и классов. " +
                        "Java активно использует ООП для создания модульного и поддерживаемого кода."
        ));

        indexUrl(new WebPage(
                "https://javaexception.com/handling",
                "Обработка исключений в Java",
                "Обработка исключений является важным аспектом разработки на Java. Она позволяет правильно " +
                        "реагировать на ошибки во время выполнения программы, минимизируя сбои."
        ));

        indexUrl(new WebPage(
                "https://javaexception.com/common-errors",
                "Частые ошибки при работе с исключениями в Java",
                "Разработка на Java требует правильной работы с исключениями. Распространенные ошибки включают " +
                        "некорректное использование try-catch и неправильное управление ресурсами."
        ));

        indexUrl(new WebPage(
                "https://javatestautomation.org/testing",
                "Тестирование и автоматизация на Java",
                "Java активно используется для автоматизированного тестирования. Iнструменты, такие как " +
                        "JUnit и TestNG, позволяют тестировать код в различных условиях."
        ));

        indexUrl(new WebPage(
                "https://javatestautomation.org/integration-testing",
                "Iнтеграционное тестирование в Java",
                "Iнтеграционное тестирование помогает проверить совместимость модулей в Java-приложениях. " +
                        "Iспользуются такие инструменты, как TestNG и Mockito."
        ));

        indexUrl(new WebPage(
                "https://javastreamapi.com/guide",
                "Iспользование Stream API в Java",
                "Stream API позволяет работать с коллекциями данных на высоком уровне абстракции, упрощая " +
                        "обработку больших объемов информации и параллелизм."
        ));

        indexUrl(new WebPage(
                "https://javastreamapi.com/advanced",
                "Продвинутое использование Stream API в Java",
                "Продвинутое использование Stream API включает такие операции, как фильтрация, маппинг и " +
                        "параллельная обработка коллекций данных."
        ));

        indexUrl(new WebPage(
                "https://javapatterns.net/design-patterns",
                "Паттерны проектирования в Java",
                "Паттерны проектирования помогают решать распространенные проблемы в архитектуре программ. " +
                        "В Java широко применяются Singleton, Factory и другие паттерн."
        ));

        indexUrl(new WebPage(
                "https://javapatterns.net/singleton-pattern",
                "Паттерн Singleton в Java",
                "Singleton — это паттерн проектирования, который гарантирует создание единственного экземпляра " +
                        "класса и предоставляет глобальную точку доступа к нему."
        ));

        printGroupedPages();

        removePage("https://javatestautomation.org/integration-testing");
        removePage("https://javatestautomation.org/testing");

        printGroupedPages();

        searchWebPage("stream").forEach(System.out::println);


    }

    static void indexUrl(WebPage webPage) {
        String[] contentWords = webPage.getContent().toLowerCase().split("\\W+");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(contentWords));

        for (String word : uniqueWords) {
                index.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    static List<WebPage> searchWebPage(String keyWord) {
        return index.getOrDefault(keyWord, new ArrayList<>());
    }

    static void removePage(String url) {
        boolean isRemoved = false;
        for (Map.Entry<String, List<WebPage>> entry : index.entrySet()) {
            List<WebPage> webPages = entry.getValue();
            if (webPages.removeIf(webPage -> webPage.getUrl().equals(url))) {
                isRemoved = true;
            }
        }
        System.out.println(url + (isRemoved ? " Удален" : " не найден"));
    }

    static void printGroupedPages() {
        for (Map.Entry<String, List<WebPage>> entry : index.entrySet()) {
            String keyword = entry.getKey();
            List<WebPage> webPages = entry.getValue();

            System.out.println("Ключевое слово: " + keyword);
            for (WebPage webPage : webPages) {
                System.out.println("\tURL: " + webPage.getUrl());
                System.out.println("\tЗаголовок: " + webPage.getTitle());
                System.out.println("\tСодержимое: " + webPage.getContent());
                System.out.println();
            }
            System.out.println();
        }
    }
}
