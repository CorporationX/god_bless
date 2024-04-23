package faang.school.godbless.GmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(new Email("Email 1", "1 Email text", true), new Email("Email 2", "2 Email text", true), new Email("Spam", "Spam Text", false));

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Email proceeded: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
