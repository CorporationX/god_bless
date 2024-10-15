package school.faang.gmailrichfilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Create a list of incoming emails
        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Body of Email 1", false),
                new Email("Email 2", "Body of Email 2", true),
                new Email("Spam", "Spam content", false)
        );

        // Create an instance of EmailProcessor
        EmailProcessor emailProcessor = new EmailProcessor();

        // Predicate to filter only important emails
        Predicate<Email> importantFilter = email -> email.isImportant();

        // Consumer to print the subject of the email
        Consumer<Email> printEmail = email -> System.out.println("Processed email: " + email.getSubject());

        // Function to transform the body of the email to uppercase
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // Process emails using the filter, transformation, and action
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        // Print the updated emails to verify the transformations
        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", Body: " + email.getBody()));
    }
}
