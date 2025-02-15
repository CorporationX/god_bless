package school.faang.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Message 1", "Message 1 text", false),
                new Email("Message 2", "Message 2 text", true),
                new Email("Spam", "Spam text", false)
        );

        emailProcessor.processEmails(emails);
    }
}