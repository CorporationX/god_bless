package bjs2_88753;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false),
                new Email("Отчет", "финансовый отчет", true)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email ->
                System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email ->
                email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        System.out.println("\nПосле обработки:");
        emails.forEach(email ->
                System.out.println("Тема: " + email.getSubject() + ", Тело: " + email.getBody()));
    }
}