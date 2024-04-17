package faang.school.godbless.gmailRFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                //делала перевод на английский, чтобы хоть как-то у меня запускался main
                new Email("Letter 1", "Text of Letter 1", false),
                new Email("Letter 2", "Text of Letter 2", true),
                new Email("Spam", "Text of Spam", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Processed letter: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
