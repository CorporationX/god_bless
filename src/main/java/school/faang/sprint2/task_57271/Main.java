package school.faang.sprint2.task_57271;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "The text of the letter 1", false),
                new Email("Letter 2", "The text of the letter 2", true),
                new Email("Spam", "The text of the spam", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("The message has been processed: "
                + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.printf("Subject: %s , body of the letter: %s",
                email.getSubject(), email.getBody()));
    }
}
