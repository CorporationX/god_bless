package gmail_rich_filters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailProcessorTest {
    private final EmailProcessor EMAIL_PROCESSOR = new EmailProcessor();

    private final List<Email> EMAILS = Arrays.asList(
            new Email("Письмо 1", "Текст письма 1", false),
            new Email("Письмо 2", "Текст письма 2", true),
            new Email("Спам", "Текст спама", false)
    );

    @BeforeEach
    void setUp() {
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        EMAIL_PROCESSOR.processEmails(EMAILS, importantFilter, printEmail, toUpperCase);
    }

    @Test
    void processEmails() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        EMAILS.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));

        assertEquals(
                "Тема: Письмо 1, Тело письма: Текст письма 1\n" +
                        "Тема: Письмо 2, Тело письма: ТЕКСТ ПИСЬМА 2\n" +
                        "Тема: Спам, Тело письма: Текст спама\n",
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}