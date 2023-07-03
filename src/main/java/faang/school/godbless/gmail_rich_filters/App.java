package faang.school.godbless.gmail_rich_filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

// Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Letter text 1", true),
                new Email("Letter 2", "Letter text 2", true),
                new Email("Spam", "Spam text", false)
        );

// Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Letter processed: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
