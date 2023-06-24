package faang.school.godbless.sprint3.gmail_filters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailProcessorTest {
    private List<Email> emails;
    private EmailProcessor emailProcessor;

    @BeforeEach
    void setUp() {
        emails = List.of(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Faang-School", "Ты в команде! Поехали!", true),
                new Email("Спам", "Текст спама", false)
        );
        emailProcessor = new EmailProcessor();
    }

    @Test
    void processEmails() {
        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, Email> toUpperCase = email -> new Email(
                email.getSubject().toUpperCase(),
                email.getBody(),
                email.isImportant()
        );
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        PrintStream console = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        System.setOut(console);

        assertEquals("Обработано письмо: FAANG-SCHOOL", output.toString().trim());
    }
}