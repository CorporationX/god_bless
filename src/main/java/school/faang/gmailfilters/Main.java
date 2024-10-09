package school.faang.gmailfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Email> emails = List.of(
                new Email("Email 1", "Text 1", false),
                new Email("Email 2", "Text 2", true),
                new Email("Spam", "Spam Text", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("letter processed: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        EmailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        emails.forEach(email ->
                System.out.println("Object: " + email.getSubject() + ", Letter body: " + email.getBody()));
    }
}
