package faang.school.godbless.lambda.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> filter = email -> email.isImportant();
        Consumer<Email> handler = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, Email> finishedEmail = email -> emails.set(emails.indexOf(email), new Email(email.getSubject(), email.getBody().toUpperCase(), email.isImportant()));

        emailProcessor.processEmails(emails, filter, handler, finishedEmail);
        System.out.println(emails);
    }
}
