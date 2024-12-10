package school.faang.sprint_2.task_bjs245920;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final List<Email> EMAILS;

    static {
        EMAILS = Arrays.asList(
                new Email("Letter 1", "Body of letter 1", true),
                new Email("Letter 2", "body of letter 2", true),
                new Email("Spam", "body of spam", false)
        );
    }

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Letter: " + email.getSubject());

        emailProcessor.processEmails(EMAILS, importantFilter, toUpperCase, printEmail);
        EMAILS.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", body: " + email.getBody()));
    }
}
