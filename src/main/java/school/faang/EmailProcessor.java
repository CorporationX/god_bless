package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("О!", "Привет, спишь?", false),
                new Email("Срочно", "А щас?", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println(email.subject());
        Function<Email, String> bodyToUpperCase = email -> email.body().toUpperCase();
        Function<Email, String> bodyToLowerCase = email -> email.body().toLowerCase();
        emailProcessor.processEmails(emails, importantFilter, bodyToUpperCase, printEmail);
        emails.forEach(email -> System.out.println(
                String.format("Тема: %s. Текст письма: %s", email.subject(), email.body())));

        emails.stream()
                .filter(Email::isImportant)
                .forEach(email -> System.out.println(
                String.format("Тема: %s. Текст письма: %s", email.subject(), email.body())
        ));

    }

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> processing, Consumer<Email> action) {
        List<Email> processedEmails = emails.stream()
                .filter(filter)
                .map(email -> new Email(email.subject(), processing.apply(email), email.isImportant()))
                .collect(Collectors.toList());
        processedEmails.forEach(action);
    }

    record Email(String subject, String body, Boolean isImportant) {
    }
}