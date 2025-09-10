package school.faang.functional_interfaces__lambdas.bjs2_87253;

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
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Письмо 2", "Текст письма 3", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        Consumer<Email> printEmail = email ->
                System.out.printf("Обработано письмо: %s - %s", email.getSubject(), email.getBody());

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
    }
}
