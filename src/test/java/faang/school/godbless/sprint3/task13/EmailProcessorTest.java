package faang.school.godbless.sprint3.task13;

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
        String expected = "false\r\n" +
                "Обработано письмо: Письмо 1\r\n" +
                "ТЕКСТ ПИСЬМА 1\r\n";

// Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false)
        );

// Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(expected, outContent.toString());
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