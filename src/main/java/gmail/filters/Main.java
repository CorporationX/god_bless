package gmail.filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Text of email 1", true),
                new Email("Email 2", "Text of email 2", true),
                new Email("Spam", "Text of spam", false)
        );

        EmailProcessor emailProcessor = new EmailProcessor();

// Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Email processed: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> {
            System.out.println(email.getBody().toUpperCase());
            return email.getBody().toUpperCase();
        };

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
