package school.faang.sprint2.bjs_45804;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final Logger logs = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", true)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> logs.info("Обработано письмо: {}", email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getEmailBody().toUpperCase();
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        emails.forEach(email -> logs.info("Тема: {}, Тело письма: {}", email.getSubject(), email.getEmailBody()));
    }
}
