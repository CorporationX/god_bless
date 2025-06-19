package school.faang.BJS2_80089;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "The text of the letter 1", false),
                new Email("Letter 2", "The text of the letter 2", true),
                new Email("Letter 3", "The text of the letter 3", false),
                new Email("Letter 4", "The text of the letter 4", true),
                new Email("Spam", "The text spam", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("The email has been processed: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println(
                "\nSubject: " + email.getSubject() + "\nBody letter: " + email.getBody()));

    }
}
