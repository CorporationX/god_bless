package school.faang.gmail.rich.filters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailProcessorTest {
    private List<Email> emails;

    private Predicate<Email> importantFilter;
    private Consumer<Email> printEmail;
    private Function<Email, String> toUpperCase;

    @BeforeEach
    public void setUp() {
        emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        importantFilter = Email::isImportant;
        printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        toUpperCase = email -> email.getBody().toUpperCase();
    }

    @Test
    void processEmailsTest() {
        List<Email> expected = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "ТЕКСТ ПИСЬМА 2", true),
                new Email("Спам", "Текст спама", false)
        );

        EmailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        assertEquals(expected, emails);
    }
}
