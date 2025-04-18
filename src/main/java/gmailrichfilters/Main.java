package gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = List.of(
                new Email("Meeting", "Don't forget our meeting at 10", true),
                new Email("Spam Offer", "Buy now!", false),
                new Email("Project Update", "Latest code pushed", true)
        );

        EmailProcessor processor = new EmailProcessor();

        Predicate<Email> isImportant = Email::isImportant;

        Function<Email, String> addSignature = email ->
                email.getBody() + "\n\n-- Sent from EmailProcessor";

        Consumer<Email> printSubject = email ->
                System.out.println("Processing email with subject: " + email.getSubject());

        processor.processEmails(emails, isImportant, addSignature, printSubject);
    }
}

