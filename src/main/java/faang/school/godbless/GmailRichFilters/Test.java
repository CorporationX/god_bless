package faang.school.godbless.GmailRichFilters;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Email 1 Body", false),
                new Email("Email 2", "Email 2 Body", true),
                new Email("Spam", "Spam Text", false)
        );

        emailProcessor.processEmails(
                emails,
                email -> email.isImportant(),
                email -> System.out.println("The email has been processed: \n   " + email),
                email -> email.getBody().toUpperCase()
        );

        emailProcessor.processEmails(
                emails,
                email -> !email.getBody().contains("Spam"),
                email -> System.out.println("The email has been processed: \n   " + email),
                email -> email.getBody() + "\nBest Regards"
        );
    }
}
