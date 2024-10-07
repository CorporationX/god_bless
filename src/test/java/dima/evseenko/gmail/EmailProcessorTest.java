package dima.evseenko.gmail;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EmailProcessorTest {

    @Test
    void processEmails() {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = new ArrayList<>(getEmails());

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertFalse(emails.contains(new Email("Письмо 1", "Текст письма 1", false)));
        assertEquals("ТЕКСТ ПИСЬМА 2", emails.get(0).getBody());
    }

    private List<Email> getEmails() {
        return List.of(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false),
                new Email("Письмо 3", "Текст письма 3", true)
        );
    }
}