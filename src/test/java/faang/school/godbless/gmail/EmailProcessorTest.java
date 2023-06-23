package faang.school.godbless.gmail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {

    private EmailProcessor emailProcessor;
    private List<Email> emails;
    private Predicate<Email> importantFilter;
    private Consumer<Email> printEmail;
    private Function<Email, String> toUpperCase;


    @BeforeEach
    public void setUp() {
        emailProcessor = new EmailProcessor();

        emails = Arrays.asList(
            new Email("Реклама", "Текст рекламы", false),
            new Email("Offer", "Добро пожаловать в команду!", true),
            new Email("Поздравляем! Вы выиграли миллион!", "Пришлите нам данные своей карты для выплаты", false)
        );

        importantFilter = Email::isImportant;
        printEmail = email -> System.out.printf("Обработано письмо: %s. Неважные письма отправлены в архив", email.getSubject());
        toUpperCase = email -> email.getSubject().toUpperCase();
    }

    @Test
    void testProcessEmailsSuccess() {
        List<Email> expected = List.of(new Email("OFFER", "Добро пожаловать в команду!", true));
        List<Email> result = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        assertEquals(expected, result);
    }

    @Test
    void testProcessEmailsThrowException() {
        assertThrows(IllegalArgumentException.class, () -> emailProcessor.processEmails(new ArrayList<>(), importantFilter, printEmail, toUpperCase));
    }
}