package faang.school.godbless.task_21_gmail_filters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailProcessorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final EmailProcessor emailProcessor = new EmailProcessor();
    private final Predicate<Email> predicate = Email::isImportant;
    private final Function<Email, String> function = email -> email.body().toUpperCase();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testProcessEmails() {
        // Arrange
        Email e = new Email("Email", "body", true);
        List<Email> emails = List.of(e);
        String consumerMessage = "Обработано письмо: ";
        Consumer<Email> consumer = email -> System.out.println(consumerMessage + email.subject());
        String exp = e.body().toUpperCase();
        // 2 = \n
        int start = (consumerMessage + e.subject()).length() + 2;
        int end = start + exp.length();

        // Act
        emailProcessor.processEmails(emails, predicate, consumer, function);

        // Assert
        assertEquals(exp, outputStreamCaptor.toString().substring(start, end), "выводы не совпадают");
    }

    @Test
    public void testProcessEmails_ignoreIsNotImportant() {
        // Arrange
        Email e = new Email("Email", "body", false);
        List<Email> emails = List.of(e);
        String consumerMessage = "Обработано письмо: ";
        Consumer<Email> consumer = email -> System.out.println(consumerMessage + email.subject());
        String exp = "";
        // 2 = \n
        int start = (consumerMessage + e.subject()).length() + 2;
        int end = start + exp.length();

        // Act
        emailProcessor.processEmails(emails, predicate, consumer, function);

        // Assert
        assertEquals(exp, outputStreamCaptor.toString().substring(start, end), "должен был пропустить письмо, потому что оно не важное");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
