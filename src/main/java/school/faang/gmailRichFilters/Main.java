package school.faang.gmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "TEXT 1", false),
                new Email("Letter 2", "TEXT 2", true),
                new Email("Spam", "spam spam spam text", false)
        );

        Predicate<Email> filter = email -> email.getIsImportant();
        Consumer<Email> action = email -> System.out.println("Letter processed " + email.getSubject());
        Function<Email, String> transformer = email -> email.getBody().toLowerCase();

        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(emails, filter, action, transformer);

        System.out.println("--------------");
        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", Email body: " + email.getBody()));

    }
}
