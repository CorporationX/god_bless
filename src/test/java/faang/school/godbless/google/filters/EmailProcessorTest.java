package faang.school.godbless.google.filters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
class EmailProcessorTest {
    EmailProcessor emailProcessor;
    List<Email> emails;
    Predicate<Email> filter;
    Consumer<Email> processing;

    @BeforeEach
    void setUp() {
        emailProcessor = new EmailProcessor();
        emails = new ArrayList<>();
        filter = Email::isImportant;
        processing = email -> System.out.println("Обработано письмо: " + email.getSubject());
    }

    @Test
    void processEmails_CorrectAnswerTest() {
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        emailProcessor.processEmails(emails, filter, processing, toUpperCase);
        String result0 = emails.get(0).getBody();
        String result1 = emails.get(1).getBody();
        String result2 = emails.get(2).getBody();
        assertEquals(result0, "Текст письма 1");
        assertEquals(result1, "Текст письма 2");
        assertEquals(result2, "Текст спама");
    }
}