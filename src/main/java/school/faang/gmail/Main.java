package school.faang.gmail;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false),
                new Email("Письмо 3", "Текст письма 3", true)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail)
                .forEach(email -> log.debug("Тема: {}, Тело письма: {}", email.getSubject(), email.getBody()));
    }
}