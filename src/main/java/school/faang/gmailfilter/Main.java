package school.faang.gmailfilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

// Список входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Email body 1", false),
                new Email("Email 2", "Email body 2", true),
                new Email("Spam", "Spam body", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Email processed: " + email.getSubject() + "Updated message: " + email.getBody());
        System.out.println("\nPROCESSED EMAILS:");
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        System.out.println("\nALL EMAILS:");
        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", Тело письма: " + email.getBody()));

        Predicate<Email> spamFilter = email -> email.getBody().toLowerCase().contains("spam");
        Function<Email, String> removeSpamWords = email -> email.getBody().replaceAll("(?i)spam", "*REMOVED*");
        System.out.println("\nSPAM EMAILS:");
        emailProcessor.processEmails(emails, spamFilter, printEmail, removeSpamWords);
    }
}
