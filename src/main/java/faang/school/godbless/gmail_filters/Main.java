package faang.school.godbless.gmail_filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        EmailProcessor ep = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Letter 1 text", false),
                new Email("Letter 2", "Letter 2 text", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Processing letter: " + email.getSubject());
        Function<Email, String> bodyToUpperCase = email -> email.getBody().toUpperCase();

        System.out.println(ep.processEmails(emails, importantFilter, printEmail, bodyToUpperCase));
        System.out.println(ep.processEmails(emails, null, null, null));
    }
}
