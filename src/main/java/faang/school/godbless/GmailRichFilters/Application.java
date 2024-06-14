package faang.school.godbless.GmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Text letter 1", false),
                new Email("Letter 2", "Text letter 2", true),
                new Email("Spam", "Text spam", false),
                new Email("Letter 3", "Text letter 3", true)
        );

        Predicate<Email> importantFilter = email -> email.getIsImportant();
        Consumer<Email> printEmail = email -> System.out.println("The letter has been processed: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
