package faang.school.godbless.aged777_BJS2_9454_gmail_rich_filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    /*

    Описание
Изменить Описание
Условия задачи
Описание: Вы являетесь разработчиком приложения GMail и работаете над функцией, которая позволяет пользователям
настраивать фильтры для обработки входящих писем. Вам необходимо создать систему, которая будет применять набор
пользовательских фильтров к входящим письмам с использованием популярных функциональных интерфейсов Predicate,
Consumer, и Function.

Цель: Создайте класс EmailProcessor, который будет использовать Predicate для фильтрации писем, Consumer для
обработки писем и Function для преобразования писем.

Требования:

Создайте класс Email с полями subject, body и isImportant;

Создайте класс EmailProcessor с методом processEmails;

Метод processEmails должен принимать список входящих писем, Predicate для фильтрации, Consumer для обработки и
Function для преобразования писем;

Создайте несколько лямбда-выражений для Predicate, Consumer, и Function;

Протестируйте вашу систему, обрабатывая несколько входящих писем с разными настройками фильтрации и обработки.

Пример использования:

EmailProcessor emailProcessor = new EmailProcessor();

// Создание списка входящих писем
List<Email> emails = Arrays.asList(
    new Email("Письмо 1", "Текст письма 1", false),
    new Email("Письмо 2", "Текст письма 2", true),
    new Email("Спам", "Текст спама", false)
);

// Создание фильтров, обработчиков и преобразователей
Predicate<Email> importantFilter = email -> email.isImportant();
Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

     */

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> !email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.subject());
        Function<Email, String> toUpperCase = email -> email.body().toUpperCase();

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
