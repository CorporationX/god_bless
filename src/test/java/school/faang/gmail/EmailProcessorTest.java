package school.faang.gmail;

import org.junit.jupiter.api.Test;
import school.faang.gmail.entity.Email;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessorTest {
    private static EmailProcessor processor = new EmailProcessor();

    @Test
    public void testProcessEmail() {
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.printf("Обработано письмо: %s\n", email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        processor.processEmail(emails, importantFilter, toUpperCase, printEmail);
    }
}
