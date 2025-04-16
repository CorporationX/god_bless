package school.faang.bjs2_70474;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", false, "Текст письма 1"),
                new Email("Письмо 2", true, "Текст письма 2"),
                new Email("Спам", false, "Текст спама")
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.printf("Обработано письмо: %s%n", email.getSubject());

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        emails.forEach(email -> System.out.printf("Тема: %s, Тело письма: %s%n", email.getSubject(), email.getBody()));
    }
}