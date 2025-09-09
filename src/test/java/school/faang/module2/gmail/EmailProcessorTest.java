package school.faang.module2.gmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EmailProcessorTest {

    @Test
    void testFilter() {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.printf("Обработано письмо: %s%n", email.subject());
        Function<Email, Email> toUpperCase = email ->
                new Email(email.subject(), email.body().toUpperCase(), email.isImportant());

        List<Email> filteredEmails = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        Assertions.assertEquals(1, filteredEmails.size());
        Assertions.assertEquals(new Email("Письмо 2", "ТЕКСТ ПИСЬМА 2", true), filteredEmails.get(0));
    }

}