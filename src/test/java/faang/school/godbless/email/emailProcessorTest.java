package faang.school.godbless.email;

import faang.school.godbless.Email;
import faang.school.godbless.EmailProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Predicate<Email> spamFilter = email -> email.getSubject().equalsIgnoreCase("Спам");
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // Обработка писем с фильтром на важность
        List<Email> filteredEmails = new ArrayList<>();
        Consumer<Email> collectFilteredEmails = filteredEmails::add;

        emailProcessor.processEmails(emails, importantFilter, collectFilteredEmails, toUpperCase);

        assertEquals(1, filteredEmails.size());
        assertEquals("ТЕКСТ ПИСЬМА 2", filteredEmails.get(0).getBody());

        // Обработка писем с фильтром на спам
        filteredEmails.clear();

        emailProcessor.processEmails(emails, spamFilter, collectFilteredEmails, toUpperCase);

        assertEquals(1, filteredEmails.size());
        assertEquals("ТЕКСТ СПАМА", filteredEmails.get(0).getBody());
    }
}
