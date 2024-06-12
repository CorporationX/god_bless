package faang.school.godbless.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Message 1", "Text message 1", false),
                new Email("Message 2", "Text message 2", true),
                new Email("Spam", "Text spam", false)
        );

        Predicate<Email> emailFilter = email -> email.getBody().contains("message");
        Function<Email, String> emailFunction = email -> email.getBody().toLowerCase();
        Consumer<Email> emailHandler = email -> System.out.println("Письмо обработано - " + email.getSubject());

        emailProcessor.processEmails(emails, emailFilter, emailHandler, emailFunction);
    }
}
