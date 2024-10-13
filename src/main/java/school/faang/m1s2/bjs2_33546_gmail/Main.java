package school.faang.m1s2.bjs2_33546_gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> filterImportant = email -> email.isImportant();
        Predicate<Email> filterNotImportant = email -> !email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Consumer<Email> toUpperCase = email -> email.setBody(email.getBody().toUpperCase());
        Consumer<Email> toLowerCase = email -> email.setBody(email.getBody().toLowerCase());

        emailProcessor.processEmails(emails, filterImportant, printEmail, toUpperCase);

        System.out.println();

        emailProcessor.processEmails(emails, filterNotImportant, printEmail, toLowerCase);

        System.out.println();
        System.out.println("Full list:");
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}