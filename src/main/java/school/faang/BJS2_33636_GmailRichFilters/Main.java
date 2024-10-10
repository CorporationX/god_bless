package school.faang.BJS2_33636_GmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor processor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Important Meeting", "Please make sure to attend the meeting tomorrow.", true),
                new Email("Casual Talk", "Just checking in to see how you are doing.", false),
                new Email("Urgent Request", "We need your input on the project ASAP.", true),
                new Email("Reminder", "Don't forget about the upcoming deadline.", true),
                new Email("Feedback Request", "Please share your feedback on the presentation.", false)
        );
        emails.forEach(email -> System.out.printf("Email subject: %s. Email body: %s\n", email.getSubject(), email.getBody()));

        Predicate<Email> filter = Email::isImportant;
        Function<Email, String> emailBodyMapper = email -> email.getBody().toUpperCase();
        Consumer<Email> emailConsumer = email ->
                System.out.printf("Message with subject %s has been processed\n", email.getSubject());

        System.out.println();
        processor.processEmails(emails, filter, emailBodyMapper, emailConsumer);
        System.out.println();
        emails.forEach(email -> System.out.printf("Email subject: %s. Email body: %s\n", email.getSubject(), email.getBody()));
    }
}
