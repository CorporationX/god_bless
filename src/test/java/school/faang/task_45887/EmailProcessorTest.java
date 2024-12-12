package school.faang.task_45887;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    private final EmailProcessor emailProcessor = new EmailProcessor();
    private Email unimportantEmail;
    private Email importantEmail;
    private Email spamEmail;
    private List<Email> emails;
    private Predicate<Email> importantFilter;
    private Consumer<Email> printEmail;
    private Function<Email, String> toUpperCase;

    @BeforeEach
    void setUp() {
        unimportantEmail = new Email("Письмо 1", "Текст письма 1", false);
        importantEmail = new Email("Письмо 2", "Текст письма 2", true);
        spamEmail = new Email("Спам", "Текст спама", false);
        emails = Arrays.asList(unimportantEmail, importantEmail, spamEmail);
        importantFilter = email -> email.isImportant();
        printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        toUpperCase = email -> email.getBody().toUpperCase();
    }

    @Test
    void testSuccessProcessEmails() {
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        assertEquals(importantEmail.getBody().toUpperCase(), emails.get(1).getBody());
    }

    @Test
    void testProcessEmailsWithNullableParameters() {
        assertThrows(IllegalArgumentException.class,
            () -> emailProcessor.processEmails(emails, null, toUpperCase, printEmail));
        assertThrows(IllegalArgumentException.class,
            () -> emailProcessor.processEmails(emails, importantFilter, null, printEmail));
        assertThrows(IllegalArgumentException.class,
            () -> emailProcessor.processEmails(emails, importantFilter, toUpperCase, null));
    }

    @Test
    void testProcessEmailsWithEmptyList() {
        List<Email> emptyList = List.of();

        assertDoesNotThrow(() -> emailProcessor.processEmails(emptyList, importantFilter, toUpperCase, printEmail));
    }

    @Test
    void testCreateEmailThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null, "body", false));
        assertThrows(IllegalArgumentException.class, () -> new Email("", "body", false));
        assertThrows(IllegalArgumentException.class, () -> new Email("subject", null, false));
        assertThrows(IllegalArgumentException.class, () -> new Email("subject", "", false));
    }
}