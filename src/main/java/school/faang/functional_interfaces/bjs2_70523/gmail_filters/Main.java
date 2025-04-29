package school.faang.functional_interfaces.bjs2_70523.gmail_filters;

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
                new Email("Letter 1", "Letter text 1", false),
                new Email("Letter 2", "Letter text 2", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> log.info("Letter is processed: {} ", email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> log.info("Subject: {}, Letter body: {}", email.getSubject(), email.getBody()));
    }
}
