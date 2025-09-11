package school.faang.bjs2_87290;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Text letter 1", false),
                new Email("Letter 2", "Text letter 2", true),
                new Email("Spam", "Text spam", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("\n" +
                "Message processed: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);


        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() +
                ", Body of the letter: " + email.getBody()));
    }
}