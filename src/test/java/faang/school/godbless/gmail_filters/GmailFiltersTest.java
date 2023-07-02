package faang.school.godbless.gmail_filters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GmailFiltersTest {
    private Email emailOne;
    private Email emailTwo;
    private Email emailThree;
    private EmailProcessor emailProcessor;
    private List<Email> emails;
    private Predicate<Email> importantFilter;
    private Consumer<Email> printEmail;
    private Function<Email, String> toUpperCase;

    @BeforeEach
    public void setUp() {
        emailOne = new Email("Письмо 1", "Текст письма 1", true);
        emailTwo = new Email("Письмо 2", "Текст письма 2", true);
        emailThree = new Email("Спам", "Текст спама", false);
        emailProcessor = new EmailProcessor();
        emails = Arrays.asList(emailOne, emailTwo, emailThree);
        importantFilter = email -> email.isImportant();
        printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        toUpperCase = email -> email.getBody().toUpperCase();
    }

    @Test
    public void testEmailsProcess() {
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        assertEquals(emailOne.isImportant(), true);
        assertEquals(emailTwo.isImportant(), true);
        assertEquals(emailThree.isImportant(), false);
    }
}
