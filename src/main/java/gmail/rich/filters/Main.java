package gmail.rich.filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> important = Email::isImportant;
        Function<Email, Email> toUpperCase =
                email -> new Email(email.subject().toUpperCase(), email.body(), email.isImportant());
        Consumer<Email> printEmail = email -> System.out.printf("Обработано письмо: %s%n", email.subject());

        Predicate<Email> spamFilter = email -> email.subject().equals("Спам");
        Function<Email, Email> censoring = email -> new Email(email.subject(), "*CENSORED*", email.isImportant());
        Consumer<Email> deletedEmail =
                email -> System.out.printf("Удаленно письмо: %s - %s%n", email.subject(), email.body());

        emailProcessor.processEmails(emails, important, toUpperCase, printEmail);
        emailProcessor.processEmails(emails, spamFilter, censoring, deletedEmail);
    }
}
