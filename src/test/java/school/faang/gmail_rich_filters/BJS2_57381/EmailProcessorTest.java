package school.faang.gmail_rich_filters.BJS2_57381;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    private List<Email> emails;
    private EmailProcessor emailProcessor;
    private Consumer<Email> consumer;
    private Predicate<Email> predicate;
    private Function<Email, String> function;

    @BeforeEach
    void setUp() {
        emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        emailProcessor = new EmailProcessor();

        consumer = e -> System.out.println("Обработанное письмо:" + e.getSubject());
        predicate = e -> e.isImportant();
        function = e -> e.getBody().toUpperCase();
    }

    @Test
    void testProcessEmails() {
        emailProcessor.processEmails(emails, predicate, function, consumer);

        assertEquals("ТЕКСТ ПИСЬМА 2", emails.get(1).getBody());
        assertEquals("Текст письма 1", emails.get(0).getBody());
        assertEquals("Текст спама", emails.get(2).getBody());
    }
}