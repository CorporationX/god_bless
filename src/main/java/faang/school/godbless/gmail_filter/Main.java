package faang.school.godbless.gmail_filter;

import lombok.AllArgsConstructor;
import lombok.Data;

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
                new Email("Письмо 3", "Текст письма 3", false),
                new Email("Письмо 4", "Текст письма 4", true)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработанно письмо " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.proccesEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}


@Data
@AllArgsConstructor
class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}


@Data
@AllArgsConstructor
class EmailProcessor {
    public void proccesEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                System.out.println("Важное сообщение " + email.getSubject());
                consumer.accept(email);
                System.out.println((function.apply(email)));
            } else {
                System.out.println("Не важное сообщение");
            }
        }
    }
}