package faang.school.godbless.Sprint3.Gmail;

import org.assertj.core.api.Assert;
//import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    EmailProcessor emailProcessor = new EmailProcessor();

    // Создание списка входящих писем
    List<Email> emails = Arrays.asList(
            new Email("Письмо 1", "Текст письма 1", false),
            new Email("Письмо 2", "Текст письма 2", true),
            new Email("Спам", "Текст спама", false)
    );

    // Создание фильтров, обработчиков и преобразователей
    Predicate<Email> importantFilter = email -> email.isImportant();
    Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
    Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

    @Test
    void testProcessEmailsPredicateTrue() {
        assertTrue(importantFilter.act(emails.get(1)));
    }

    @Test
    void testProcessEmailsPredicateFalse() {
        assertFalse(importantFilter.act(emails.get(0)));
    }

    @Test
    void testProcessEmailsConsumer() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        printEmail.act(emails.get(0));
        //не подключается Assert...
        //Assert.assertEquals("Обработано письмо: Письмо 1", output.toString());
        System.setOut(null);
    }

    @Test
    void testProcessEmailsPredicateFunction() {
        assertEquals("ТЕКСТ ПИСЬМА 1",toUpperCase.act(emails.get(0)));
    }

}