package faang.school.godbless.javalambda.task5.test;

import faang.school.godbless.javalambda.task5.Email;
import faang.school.godbless.javalambda.task5.EmailProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    EmailProcessor emailProcessor;
    List<Email> emails;

    @BeforeEach
    void setUp() {
        emailProcessor = new EmailProcessor();

        emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
    }

    @Test
    void processEmails_shouldCorrectly() {
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        List<Email> emailList = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(1, emailList.size());
        Email email = emailList.get(0);
        assertEquals("Письмо 2" , email.getSubject());
        assertEquals("ТЕКСТ ПИСЬМА 2" , email.getBody());
        assertTrue(email.isImportant());
    }
}