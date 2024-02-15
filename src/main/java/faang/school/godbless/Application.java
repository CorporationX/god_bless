package faang.school.godbless;

import faang.school.godbless.GmailRichFilters.Email;
import faang.school.godbless.GmailRichFilters.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
    public static void main(String... args) {
        EmailProcessor emailProcessor = new EmailProcessor();

// Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", true),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

// Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
