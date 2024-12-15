package school.faang.gmailfilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();


        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Text email 1", false),
                new Email("Email 2", "Text email 2", true),
                new Email("Spam", "Text spam", false)
        );


        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Email processed: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();


        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email ->
                System.out.println("Subject: " + email.getSubject() + ", Body email : " + email.getBody()));

    }
}
