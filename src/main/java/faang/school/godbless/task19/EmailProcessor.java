package faang.school.godbless.task19;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

// Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обрабатывается письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }

    public List<String> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> consumer, Function<Email, String> function) {
        List<Email> filteredEmails = emails.stream().filter(filter).toList();
        filteredEmails.forEach(consumer);
         return filteredEmails.stream().map(function).toList();
    }
}
