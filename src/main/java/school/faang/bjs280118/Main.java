package school.faang.bjs280118;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = email ->
                email.isImportant();
        Consumer<Email> printEmail = email ->
                System.out.printf("Обработано письмо: %s" ,  email.getSubject());
        Function<Email, String> toUpperCase = email ->
                email.getBody().toUpperCase();

        List<Email> processedEmails = emails.stream()
                .filter(importantFilter)
                .collect(Collectors.toList());

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        processedEmails.forEach(email ->
                System.out.printf("Тема: %s, Тело письма: %s%n", email.getSubject(), email.getBody()));
    }
}
