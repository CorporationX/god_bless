package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("О!", "Привет, спишь?", false),
                new Email("Срочно", "А щас?", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println(email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        emails.forEach(email -> System.out.println("Тема: "
                + email.getSubject() + " Текст письма: " + email.getBody()));

        emails.stream()
                .filter(Email::isImportant)
                .forEach(email -> System.out.println("Тема: "
                        + email.getSubject() + " Текст письма: " + email.getBody()));

    }

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> processing, Consumer<Email> action) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String processingEmail = processing.apply(email);
                email.setBody(processingEmail);
                action.accept(email);
            }
        }
    }
}