package faang.school.godbless.sprint3Java8FunctionalInterfacesAndLambdas.task6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> email.isImportant();
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject() +
                ", содержание: " + email.getBody());

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
    }
}
