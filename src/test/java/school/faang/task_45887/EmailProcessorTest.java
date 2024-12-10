package school.faang.task_45887;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    private final EmailProcessor emailProcessor = new EmailProcessor();

    @Test
    void testProcessEmails() {
        var unimportantEmail = new Email("Письмо 1", "Текст письма 1", false);
        var importantEmail = new Email("Письмо 2", "Текст письма 2", true);
        var spamEmail = new Email("Спам", "Текст спама", false);
        List<Email> emails = Arrays.asList(unimportantEmail, importantEmail, spamEmail);

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        assertEquals(importantEmail.getBody().toUpperCase(), emails.get(1).getBody());
    }
}