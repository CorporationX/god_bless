package faang.school.godbless.lambda_stream.gmail_filters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {

    @Test
    void testProcessEmails() {
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, Email> toUpperCase = email ->
                new Email(email.getSubject().toUpperCase(), email.getBody(), email.isImportant());

        EmailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(3, emails.size());
        assertEquals("ПИСЬМО 2", emails.get(1).getSubject());
    }
}