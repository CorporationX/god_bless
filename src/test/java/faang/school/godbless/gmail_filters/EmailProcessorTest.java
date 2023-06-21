package faang.school.godbless.gmail_filters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {

    @Test
    void testProcessEmails() {
        List<Email> emails = Arrays.asList(
                new Email("������ 1", "����� ������ 1", false),
                new Email("������ 2", "����� ������ 2", true),
                new Email("����", "����� �����", false)
        );
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("���������� ������: " + email.getSubject());
        Function<Email, Email> toUpperCase = email ->
                new Email(email.getSubject().toUpperCase(), email.getBody(), email.isImportant());

        List<Email> processedEmails = EmailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(1, processedEmails.size());
        assertEquals("������ 2", processedEmails.get(0).getSubject());
    }
}