package faang.school.godbless.sprint3.GmailFilters.classes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    private static ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private static EmailProcessor emailProcessor;
    private static List<Email> emails;
    private static Predicate<Email> predicate = Email::isImportant;
    private static Consumer<Email> consumer = email -> System.out.println("Обработанно письмо: " + email.getSubject());
    private static Function<Email, String> function = email -> email.getBody().toUpperCase();

    @BeforeAll
    public static void setUp() {
        emailProcessor = new EmailProcessor();
        emails = List.of(
                new Email("Yandex", "Приглашение на собеседование", true),
                new Email("Email 2", "Text", false),
                new Email("Email 3", "Whatever", true)
        );
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("")
    void processEmail_test() {
        List<Email> list = emailProcessor.processEmail(emails, predicate, consumer, function);
        assertEquals(2, list.size());
        assertTrue(byteArrayOutputStream
                .toString()
                .trim()
                .contains("Обработанно письмо: " + list.get(0).getSubject()));
    }

    @AfterEach
    public void cleanConsole() {
        byteArrayOutputStream.reset();
    }

    @AfterAll
    public static void cleanUpStream() {
        System.setOut(null);
    }
}