package faang.school.godbless.gmail_rich_filters;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(@NonNull List<Email> letters, @NonNull Predicate<Email> predicate, @NonNull Consumer<Email> consumer, @NonNull Function<Email, String> function) {
        for (Email email : letters) {
            if (predicate.test(email)) {
                email.setSubject(function.apply(email));
                consumer.accept(email);
            }
        }
    }

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false),
                new Email("Notification", "You received new notification", true)
        );

        Predicate<Email> isNotBlankMessage = email -> !email.getBody().isBlank();
        Consumer<Email> sendMessage = email -> System.out.printf("Sending email: %s\n", email);
        Function<Email, String> importantFunction = email -> {
            if (email.isImportant()) {
                return "Важно! " + email.getSubject();
            } else {
                return email.getSubject();
            }
        };


        emailProcessor.processEmails(emails, isNotBlankMessage, sendMessage, importantFunction);
    }
}
