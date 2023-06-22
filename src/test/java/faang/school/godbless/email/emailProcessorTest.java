package faang.school.godbless.email;

import faang.school.godbless.Email;
import faang.school.godbless.EmailProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class emailProcessorTest {
    EmailProcessor emailProcessor;

    @BeforeEach
    public void setUp() {
        emailProcessor = new EmailProcessor();
    }


    @Test
    public void testProcessEmails() {

        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Message 1", "Text of message 1", false),
                new Email("Message 2", "Text of message 2", true),
                new Email("spam", "Text spam", false)
        );

        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> printEmail = email -> email.getSubject();
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        String expectedOutput = "Message 2 TEXT OF MESSAGE 2";
        List<String> filteredEmails = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        // Проверка вывода
        assertEquals(expectedOutput, filteredEmails.get(0));


    }
}
