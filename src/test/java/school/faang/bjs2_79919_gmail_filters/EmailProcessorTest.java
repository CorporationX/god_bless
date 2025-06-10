package school.faang.bjs2_79919_gmail_filters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EmailProcessorTest {
    private EmailProcessor emailProcessor = new EmailProcessor();
    private List<Email> basicEmails = Arrays.asList(
            new Email("Письмо 1", "Текст письма 1", false),
            new Email("Письмо 2", "Текст письма 2", true),
            new Email("Спам", "Текст спама", false)
    );
    private Predicate<Email> importantFilter = Email::isImportant;
    private Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
    private Function<Email, String> toUpperCase = email -> {
        email.setBody(email.getBody().toUpperCase());
        return email.getBody();
    };

    @Test
    void processEmailsShouldNotAcceptNullFunctions() {
        assertThrows(IllegalArgumentException.class, () ->
                emailProcessor.processEmails(basicEmails, null, null, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                emailProcessor.processEmails(basicEmails, importantFilter, null, null)
        );
        assertThrows(IllegalArgumentException.class, () ->
                emailProcessor.processEmails(basicEmails, importantFilter, printEmail, null)
        );
    }

    @Test
    void processEmailsShouldAlwaysCallAnnounce() {
        Predicate<Email> alwaysSkip = email -> false;
        @SuppressWarnings("unchecked")
        Consumer<Email> announce = (Consumer<Email>) mock(Consumer.class);

        emailProcessor.processEmails(basicEmails, alwaysSkip, announce, toUpperCase);
        verify(announce, times(3)).accept(any(Email.class));
    }

    @Test
    void processEmailsShouldTransformOnlyFiltered() {
        @SuppressWarnings("unchecked")
        Function<Email, String> transform = (Function<Email, String>) mock(Function.class);

        emailProcessor.processEmails(basicEmails, importantFilter, printEmail, transform);
        verify(transform, times(1)).apply(basicEmails.get(1));
    }
}