package faang.school.godbless.BJS221345;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Text email 1", true),
                new Email("Email 2", "Text email 2", true),
                new Email("Spam", "Text spam", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("letter processed --> " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            System.out.println(email.getBody().toUpperCase());
            return email.getBody().toUpperCase();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

    }
}
