package faang.school.godbless.GmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
    public static void main(String... args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Letter text 1", false),
                new Email("Letter 2", "Letter text 2", true),
                new Email("Spam", "Spam text", false)
        );
        Predicate<Email> importantFilter = Email::getIsImportant;
        Consumer<Email> printEmail = email -> System.out.println("Letter processed: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
