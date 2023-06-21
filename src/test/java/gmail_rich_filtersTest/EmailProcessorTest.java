package gmail_rich_filtersTest;

import faang.school.godbless.gmail_rich_filters.Email;
import faang.school.godbless.gmail_rich_filters.EmailProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailProcessorTest {

    Predicate<Email> filter = Email::isImportant;
    Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
    Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

    @Test
    public void testProcessorEmails() {
        List<Email> list = List.of(
                new Email("#1", "text 1", false),
                new Email("#2", "text 2", true),
                new Email("#3", "text 3", false)
        );

        EmailProcessor processor = new EmailProcessor();

        processor.processorEmails(list, filter, printEmail, toUpperCase);
        String expected = list.get(1).getBody();
        String result = "TEXT 2";

        assertEquals(expected, result);
    }

    @Test
    public void testProcessorEmailIllegalArgumentException() {
        List<Email> list = List.of();
        EmailProcessor processor = new EmailProcessor();

        assertThrows(IllegalArgumentException.class, () -> processor.processorEmails(list
                , filter, printEmail, toUpperCase), "empty list");
    }
}
