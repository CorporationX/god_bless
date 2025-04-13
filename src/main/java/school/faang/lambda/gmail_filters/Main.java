package school.faang.lambda.gmail_filters;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Email> emails = List.of(
                new Email("Letter 1", "Your First Letter", true),
                new Email("Letter 2", "Your Second Letter", true),
                new Email("Spam 1", "Your First Spam", false),
                new Email("Spam 2", "Your Second Letter", false), //Ловушка в body
                new Email("Letter 3", "Your Third Letter", true),
                new Email("Letter 4", "Your Fourth Letter", true),
                new Email("Spam 3", "Your Third Spam", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Predicate<Email> showSpam = email -> !email.isImportant();
        Consumer<Email> printImportant = email -> log.info("Letter {} is important", email);
        Consumer<Email> printSpam = email -> log.info("{} is spam", email);
        Function<Email, String> bodyToUpper = email -> email.getBody().toUpperCase();
        Function<Email, String> spamAttention = email -> "Before you read this letter, remember this is a SPAM LETTER! "
                + email.getBody();

        EmailProcessor firstProcessor = new EmailProcessor();

        firstProcessor.processEmails(emails, importantFilter, printImportant, bodyToUpper);
        firstProcessor.processEmails(emails, showSpam, printSpam, spamAttention);

        emails.forEach(email -> log.info("Subject: {}, Body: {}", email.getSubject(), email.getBody()));

    }
}
