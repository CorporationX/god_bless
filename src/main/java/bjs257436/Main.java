package bjs257436;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> LOGGER.info("Handled letter: {}", email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email
                -> LOGGER.info("Topic: {}, Letter`s body: {}", email.getSubject(), email.getBody()));
    }
}
