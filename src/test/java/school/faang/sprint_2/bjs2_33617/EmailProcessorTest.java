package school.faang.sprint_2.bjs2_33617;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    @Test
    void testEmailProcessor() {
        EmailProcessor emailProcessor = new EmailProcessor();

        Email invalidEmail = new Email("invalid mail", "Текст письма 1", false);
        Email validEmail = new Email("valid mail", "Текст письма 2", true);
        List<Email> emails = Arrays.asList(
                invalidEmail, validEmail
        );

        String invalidEmailBodyBeforeProcess = invalidEmail.getBody();
        String validEmailBodyBeforeProcess = validEmail.getBody();

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(invalidEmail.getBody(), invalidEmailBodyBeforeProcess);
        assertNotEquals(validEmail.getBody(), validEmailBodyBeforeProcess);
        assertTrue(validEmail.getBody().equalsIgnoreCase(validEmailBodyBeforeProcess));
    }
}