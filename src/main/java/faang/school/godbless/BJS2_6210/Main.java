package faang.school.godbless.BJS2_6210;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Mail 1", "Mail body 1", false),
                new Email("Mail 2", "Mail body 2", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Email has been processed: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        for (Email email : emails) {
            System.out.printf("Subject: %s | %s%n", email.getSubject(), email.getBody());
        }
    }
}
