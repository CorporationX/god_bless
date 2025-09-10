package bjs290863;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Mail {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("letter 1", "body of letter 1", false),
                new Email("letter 2", "body of letter 2", true),
                new Email("spam", "body of letter", false)
        );

        Predicate<Email> emailFilter = email -> email.isImportant();
        Function<Email, String> emailEditorToUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Email " + email.getSubject() + " is printed");

        emailProcessor.processEmails(emails, emailFilter, printEmail, emailEditorToUpperCase);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject()
                + ", body of letter: " + email.getBody()));
    }
}
