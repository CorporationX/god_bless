package school.faang.bjs270531;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Email 2 text", false),
                new Email("Email 2", "Email 2 text", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Email processed: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println("Theme: " + email.getSubject() + ", Body: " + email.getBody()));
    }
}
