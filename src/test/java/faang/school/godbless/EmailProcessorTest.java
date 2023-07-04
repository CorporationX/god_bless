package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailProcessorTest {
    List<Email> emails;
    EmailProcessor emailProcessor;

    @BeforeEach
    void setUp() {
        emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        emailProcessor = new EmailProcessor();
    }

    @Test
    void testProcessEmailsToUpperCase() {
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(emails.get(1).getBody(), "Текст письма 2".toUpperCase());
        assertEquals(emails.get(0).getBody(), "Текст письма 1");
        assertEquals(emails.get(2).getBody(), "Текст спама");
    }

    @Test
    void testProcessEmailToSpam() {
        Predicate<Email> importantFilter = email -> !email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Письмо: '" + email.getSubject() + "' летит в спам");
        Function<Email, String> toUpperCase = email -> email.getBody().toLowerCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(emails.get(1).getBody(), "Текст письма 2");
        assertEquals(emails.get(0).getBody(), "текст письма 1");
        assertEquals(emails.get(2).getBody(), "текст спама");
    }
}