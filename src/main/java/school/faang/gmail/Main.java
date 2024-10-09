package school.faang.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {


        EmailProcessor emailProcessor = new EmailProcessor();


        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Text letter 1", true),
                new Email("Letter 2", "Text letter 2", true),
                new Email("Spam", "Text of spam", false)
        );


        Predicate<Email> importantFilter = email -> email.getIsImportant();


        Consumer<Email> printEmail = email -> System.out.println("The letter has been processed: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject()
                + ", Body of letter: " + email.getBody()));
    }
}