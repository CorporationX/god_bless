package school.faang.bjs2_80051;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Application {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Groceries", "Shopping list", true),
                new Email("Kids", "Important list for school", true),
                new Email("Garden Needs", "Checklist for backyard", false),
                new Email("Spam", "Click here to win!", false)
        );

        Predicate<Email> importantOnly = Email::isImportant;

        Consumer<Email> logImportant = email ->
                log.info("Processed important email: {}", email.getSubject());

        Function<Email, String> toUpperCaseBody = email ->
                email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantOnly, logImportant, toUpperCaseBody);

        log.info("Final state of emails:");
        emails.forEach(email ->
                log.info("Subject: {}, Body: {}", email.getSubject(), email.getBody()));
    }
}
