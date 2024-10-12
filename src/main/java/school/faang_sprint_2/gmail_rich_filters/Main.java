package school.faang_sprint_2.gmail_rich_filters;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        var emailProcessor = new EmailProcessor();
        var emails = Arrays.asList(
                new Email("Letter 1", "Text of the first letter 1", true),
                new Email("Letter 2", "Text of the second letter 2", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("The letter has been processed: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", Letter body: " + email.getBody()));
    }
}
