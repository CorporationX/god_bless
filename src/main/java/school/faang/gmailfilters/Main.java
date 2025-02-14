package school.faang.gmailfilters;

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
                new Email("Спам", "Текст спама", false)
        );

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо:  " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Predicate<Email> importantFilter = Email::isImportant;
        try {
            emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
        }
        emails.forEach(email -> System.out.printf("Тема письма: %s , Текст: %s", email.getSubject(), email.getBody()));
    }
}
