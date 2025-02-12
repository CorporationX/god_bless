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
        try {
            EmailProcessor emailProcessor = new EmailProcessor();

            List<Email> emails = Arrays.asList(
                    new Email("Письмо 1", "Текст письма 1", false),
                    new Email("Письмо 2", "Текст письма 2", true),
                    new Email("Письмо 3", "Текст письма 3", true),
                    new Email("Письмо 4", "Текст письма 4", false),
                    new Email("Письмо 5", "Текст письма 5", true),
                    new Email("Спам 1", "Текст спама 1", false),
                    new Email("Спам 2", "Текст спама 2", false),
                    new Email("Спам 3", "Текст спама 3", false),
                    new Email("Спам 4", "Текст спама 4", false)
            );

            Predicate<Email> importantFilter = Email::isImportant;
            Function<Email, String> toUpperCaseBody = email -> email.getBody().toUpperCase();
            Consumer<Email> printEmail = email ->
                    log.info("Обработано письмо: {}", email.getSubject());

            emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCaseBody);

            Predicate<Email> spamFilter = email -> email.getSubject().contains("Спам");
            Function<Email, String> replaceBody = email -> "DON'T READ";
            Consumer<Email> printEmailWithoutSpam = email ->
                    log.info("Письмо спам: {}", email.getSubject());

            emailProcessor.processEmails(emails, spamFilter, printEmailWithoutSpam, replaceBody);

            emails.forEach(email ->
                    log.info("Тема: {}, тело письма: {}", email.getSubject(), email.getBody()));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
