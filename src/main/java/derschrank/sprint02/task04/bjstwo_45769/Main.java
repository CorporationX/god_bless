package derschrank.sprint02.task04.bjstwo_45769;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Список входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Brief 1", "Letter text 1", false),
                new Email("Brief 2", "Letter text 2", true),
                new Email("Spam 1", "Spam letter 1", true),
                new Email("Spam 2", "Spam letter 2", false),
                new Email("Brief 3", "Letter text 3", false),
                new Email("Brief 4", "Letter text 4", true)
        );

        // Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = email -> email.isImportant();

        // Преобразователь, который переводит текст письма в верхний регистр
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getSubject();
        };

        // Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail =
                email -> System.out.println("The letter has been processed: " + email.getSubject());

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        // Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        System.out.println("\nAfter processing:");
        emails.forEach(System.out::println);
    }
}
