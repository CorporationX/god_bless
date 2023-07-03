package faang.school.godbless.sprint3.task13;

import faang.school.godbless.sprint3.lambda.task13.Email;
import faang.school.godbless.sprint3.lambda.task13.EmailProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void setOut() {
        System.setOut(originalOut);
    }

    @Test
    void testProcessEmails() {
        EmailProcessor emailProcessor = new EmailProcessor();
        String expected = "Обработано письмо: Письмо 1\r\n";
        String expectedBody = "ТЕКСТ ПИСЬМА 1";

// Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", true)
        );

// Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());


// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(expected, outContent.toString());
        assertEquals(expectedBody, emails.get(0).getBody());
    }

    @Test
    void testValidationFunctionalInterfacesIsNull() {
        assertThrows(NullPointerException.class, () -> new EmailProcessor().processEmails(
                List.of(new Email("1", "2", false)), null, null, null));
    }

    @Test
    void testValidationListIsEmpty() {
        assertThrows(NullPointerException.class, () -> new EmailProcessor().processEmails(null, null, null, null));
    }

}