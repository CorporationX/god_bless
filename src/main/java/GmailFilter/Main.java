package GmailFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = new ArrayList<>(List.of(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        ));

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> emailFilter = (email) -> email.isImportant();

        Consumer<Email> emailConsumer = (email) -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> emailModifier = (email) -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, emailFilter, emailModifier, emailConsumer);

        emails.forEach(email -> System.out.println(email.getBody()));
    }
}
