package school.faang.gmail_filters;

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
                new Email("Notification", "Your account has been hacked!", true),
                new Email("Mailing", "Welcome to BootCamp 2.0", false),
                new Email("Spam", "Congratulations, you won!!!", false)
        );

        Predicate<Email> checkerIsImportant = email -> email.isImportant();
        Function<Email, String> converterEmail = email -> "NOTE!: " + email.getBody().toUpperCase();
        Consumer<Email> printerEmail = email -> log.info("New important email {}", email.getBody());

        emailProcessor.processEmails(emails, checkerIsImportant, converterEmail, printerEmail);
        emails.forEach(email -> log.info("Topic: {} | Text: {}", email.getSubject(), email.getBody()));
    }
}
