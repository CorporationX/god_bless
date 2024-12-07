package school.faang.task_45754;

import school.faang.task_45754.model.Email;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Email body 1", true),
                new Email("Email 1", "Email body 2", true),
                new Email("Spam", "Email body 3", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Processed email: " + email.getSubject());
        Function<Email, Email> toUpperCase = email -> {
            return new Email(email.getSubject(), email.getBody().toUpperCase(), email.isImportant());
        };

        List<Email> newEmails = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        newEmails.forEach(email -> {
            System.out.println("Subject: " + email.getSubject() + ", Body: " + email.getBody());
        });
    }
}
