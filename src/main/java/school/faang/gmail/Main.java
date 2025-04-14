package school.faang.gmail;

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
                new Email("Спам", "Текст спама", false),
                new Email("Письмо 3", "Текст письма 3", true)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.subject());

        Function<Email, String> toUpperCase = email -> email.body().toUpperCase();

        List<Email> newEmail = emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        newEmail.forEach(email -> System.out.println("Тема: " + email.subject() + ", Тело письма: " + email.body()));
    }
}