package faang.school.godbless.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String... args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Some text 1", false),
                new Email("Letter 2", "Some text 2", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("The letter: \"" + email.getSubject() + "\" has been processed");
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        for (Email email : emails) {
            System.out.println(email);
        }
    }
}
