package school.faang.task_45836;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Email body 1", false),
                new Email("Email 2", "Email body 2", true),
                new Email("Spam", "Spam body", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        Consumer<Email> printEmail = email ->
                System.out.println("Processed email: " + email.getSubject());

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email ->
                System.out.println("Subject: " + email.getSubject() + ", Body: " + email.getBody()));
    }
}