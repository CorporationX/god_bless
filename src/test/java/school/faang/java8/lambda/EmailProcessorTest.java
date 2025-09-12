package school.faang.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailProcessorTest {
    @Test
    void emailProcessorTest() {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };
        assertEquals("Текст письма 1", emails.get(0).getBody());
        assertEquals("Текст письма 2", emails.get(1).getBody());
        assertEquals("Текст спама", emails.get(2).getBody());

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        assertEquals("Текст письма 1", emails.get(0).getBody());
        assertEquals("ТЕКСТ ПИСЬМА 2", emails.get(1).getBody());
        assertEquals("Текст спама", emails.get(2).getBody());

        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}
