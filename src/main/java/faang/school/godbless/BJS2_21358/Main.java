package faang.school.godbless.BJS2_21358;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Email text 1", false),
                new Email("Email 2", "Email text 2", true),
                new Email("Spam", "Spam text", false));
        Predicate<Email> filter = Email::isImportant;
        Consumer<Email> emailHandler = email -> System.out.println("Processed email: " + email.getSubject());
        Function<Email, String> emailConversion = email -> email.getBody().toUpperCase();
        emailProcessor.processEmails(emails, filter, emailHandler, emailConversion);
    }
}
