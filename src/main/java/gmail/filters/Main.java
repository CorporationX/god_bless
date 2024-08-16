package gmail.filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Message 1", "Text message 1", false),
                new Email("Message 2", "Text message 2", true),
                new Email("Message 3", "Text message 3", false)
        );

        Predicate<Email> importantFilter = email -> {
            if (email.isImportant()) {
                System.out.println("Это не спам");
            } else {
                System.out.println("Это спам");
            }
            return email.isImportant();
        };

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            System.out.println(email.getBody().toUpperCase());
            return email.getBody().toUpperCase();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

    }
}
