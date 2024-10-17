package mod1sp12.gmailRichFilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Predicate<Email> unimportantFilter = email -> !email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Consumer<Email> printAllInfo = email -> {
            System.out.println("Обработано письмо: " + email.getSubject());
            System.out.println("Текст письма: " + email.getBody());
        };

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        emailProcessor.processEmails(emails, unimportantFilter, printAllInfo, toLowerCase);

        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}