package faang.school.godbless.gmail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailProcessorTest {
    private EmailProcessor emailProcessor;

    @BeforeEach
    void setUp() {
        emailProcessor = new EmailProcessor();
    }

    @Test
    void processEmailsTest() {
        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
            new Email("Письмо 1", "Текст письма 1", false),
            new Email("Письмо 2", "Текст письма 2", true),
            new Email("Спам", "Текст спама", false)
        );

        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals("Текст письма 1", emails.get(0).getBody());
        assertEquals("ТЕКСТ ПИСЬМА 2", emails.get(1).getBody());
        assertEquals("Текст спама", emails.get(2).getBody());
    }

    @Test
    void processEmailsWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () ->
            emailProcessor.processEmails(Collections.emptyList(), null, null, null));
    }
}