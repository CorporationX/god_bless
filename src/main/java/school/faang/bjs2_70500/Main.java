package school.faang.bjs2_70500;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Text of the letter 1", false),
                new Email("Letter 2", "Text of the letter 2", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> log.info("The letter has been processed: {}", email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> log.info("Topic: {}, Text of the letter: {}", email.getSubject(), email.getBody()));
    }
}