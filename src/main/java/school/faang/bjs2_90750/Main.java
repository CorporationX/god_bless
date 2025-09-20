package school.faang.bjs2_90750;

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

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.printf(
                "%nОбработано письмо: %s, %s%n%n", email.getSubject(), email.getBody());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        List<Email> updatedEmails = emailProcessor.processEmails(
                emails, importantFilter, printEmail, toUpperCase);

        System.out.println("Итоговый список писем:");
        updatedEmails.forEach(email ->
                System.out.printf("Тема: %s, Тело: %s%n", email.getSubject(), email.getBody())
        );
    }
}