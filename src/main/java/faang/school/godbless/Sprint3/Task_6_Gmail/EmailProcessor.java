package faang.school.godbless.Sprint3.Task_6_Gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails (List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> function) {
        emails.forEach(email -> {
            filter.test(email);
            handler.accept(email);
            function.apply(email);
        });
    }

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
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
