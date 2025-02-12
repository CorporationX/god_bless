package school.faang.naughtwoBJS257332;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Granny", "Hello, little pie, how are you?", false),
                new Email("Petrozavodsk State University",
                        "Dear applicant, we are pleased to inform you " +
                                "that you have successfully passed all entrance exams " +
                                "and have been enrolled in our university.", true),
                new Email("You've been hacked!", "TRANSFER ALL YOUR MONEY TO A SECURE ACCOUNT IMMEDIATELY!",
                        false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Predicate<Email> spamFilter = email -> email.getBody().contains("TRANSFER ALL YOUR MONEY");

        Consumer<Email> printEmail = email -> System.out.println("Letter processed: " + email.getSubject());
        Consumer<Email> printBody = email -> System.out.println("Body: " + email.getBody());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();

        emailProcessor.processEmails(emails, spamFilter, printBody, toLowerCase);
        emails.forEach(email -> System.out.printf("%nSubject: %s%nBody:%n%s %n",
                email.getSubject(), email.getBody()));

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        emails.forEach(email -> System.out.printf("%nSubject: %s%nBody:%n%s %n",
                email.getSubject(), email.getBody()));
    }
}