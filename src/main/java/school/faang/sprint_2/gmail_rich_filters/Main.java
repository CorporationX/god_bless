package school.faang.sprint_2.gmail_rich_filters;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> important = Email::isImportant;
        Function<Email, String> toUpperCase =
                email -> email.body().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.printf("Обработано письмо: %s%n", email.subject());

        emailProcessor.processEmails(emails, important, toUpperCase, printEmail);
    }
}
