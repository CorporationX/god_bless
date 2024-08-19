package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = List.of(
                new Email("Important letter", " ASAP ", true),
                new Email("Not important letter", " Smth ", false),
                new Email("Not important letter", "      ", true),
                new Email("Let", null, true),
                new Email("Spam", "It's spam", true)
        );

        Predicate<Email> predicate = email -> (email.isImportant() &&
                (email.getBody() != null && !email.getBody().isBlank()) &&
                !email.getBody().contains("spam"));
        Consumer<Email> consumer = email -> System.out.println("Subject " + email.getSubject() + " Body " + email.getBody());
        Function<Email, String> trimmer = email -> email.getBody().trim();

        emailProcessor.processEmails(emails, predicate, consumer, trimmer);
    }
}
