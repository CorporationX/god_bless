package school.faang.bjs_45873;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Email 1", false, "The text of the letter 1"),
                new Email("Email 2", true, "The text of the letter 2"),
                new Email("Spam", false, "The text of the spam")
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("Processed email: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        List<Email> processedEmails = emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        processedEmails.forEach(System.out::println);
    }
}
