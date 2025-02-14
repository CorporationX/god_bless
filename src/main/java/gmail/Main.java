package gmail;

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

        Predicate<Email> filter = Email::isImportant;

        Consumer<Email> printEmail = email ->
                System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUppercase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, filter, printEmail, toUppercase);

        emails.forEach(email -> System.out.printf("Тема: %s, Тело письма: %s %n", email.getSubject(), email.getBody()));
    }
}
