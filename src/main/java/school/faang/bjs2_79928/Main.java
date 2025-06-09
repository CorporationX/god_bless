package school.faang.bjs2_79928;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = List.of(
                new Email("Тема 1", "ТеКст ТЕМЫ 1", true),
                new Email("Тема 2", "Текст темы 2", false),
                new Email("Тема 3", "Текст темы 3", true)
        );

        Predicate<Email> filter = Email::isImportant;
        Function<Email, String> action = email -> email.getBody().toLowerCase();
        Consumer<Email> handler = email -> log.info("Обрабатываю письмо: " + email.getSubject());

        emailProcessor.processEmails(emails, filter, action, handler);

        log.info(emails.toString());
    }
}
