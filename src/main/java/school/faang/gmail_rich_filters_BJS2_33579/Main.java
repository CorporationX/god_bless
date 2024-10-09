package school.faang.gmail_rich_filters_BJS2_33579;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Email Body 1", false),
                new Email("Email 2", "Email Body 2", true),
                new Email("Spam", "Spam Body", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Predicate<Email> notImportantFilter = email -> !email.isImportant();

        Consumer<Email> printImportantEmail = email -> System.out.println("Обработано важное письмо: " + email.getSubject());
        Consumer<Email> printNotImportantEmail = email -> System.out.println("Обработано неважное письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();

        emailProcessor.processEmails(emails, importantFilter, printImportantEmail, toUpperCase);
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));

        emailProcessor.processEmails(emails, notImportantFilter, printNotImportantEmail, toLowerCase);
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}
