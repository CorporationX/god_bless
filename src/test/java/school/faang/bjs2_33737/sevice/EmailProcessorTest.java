package school.faang.bjs2_33737.sevice;

import org.junit.jupiter.api.Test;
import school.faang.bjs2_33737.model.Email;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    private final EmailProcessor emailProcessor = new EmailProcessor();

    @Test
    void processEmails() {
        List<Email> emails = List.of(
                new Email("Welcome Letter", "Welcome to our service! We're glad to have you.", true)
        );
        Email correctEmailResult = new Email("Welcome Letter", "Welcome to our service! We're glad to have you." + " UPDATE BODY", true);

        Predicate<Email> emailFilter = Email::isImportant;
        Function<Email, String> emailUpdateBody = email -> email.getBody() + " UPDATE BODY";
        Consumer<Email> processedEmail = email -> System.out.println("update: " + email);

        IllegalArgumentException illegalArgumentExceptionEmailsNull = assertThrows(IllegalArgumentException.class,
                () -> emailProcessor.processEmails(null, emailFilter, emailUpdateBody, processedEmail));
        assertEquals("the emails list cannot be null", illegalArgumentExceptionEmailsNull.getMessage());

        IllegalArgumentException illegalArgumentExceptionEmailFilterNull = assertThrows(IllegalArgumentException.class,
                () -> emailProcessor.processEmails(emails, null, emailUpdateBody, processedEmail));
        assertEquals("the email filter cannot be null", illegalArgumentExceptionEmailFilterNull.getMessage());

        IllegalArgumentException illegalArgumentExceptionEmailUpdateBodyNull = assertThrows(IllegalArgumentException.class,
                () -> emailProcessor.processEmails(emails, emailFilter, null, processedEmail));
        assertEquals("the email body transformer cannot be null", illegalArgumentExceptionEmailUpdateBodyNull.getMessage());

        IllegalArgumentException illegalArgumentExceptionEmailProcessorNull = assertThrows(IllegalArgumentException.class,
                () -> emailProcessor.processEmails(emails, emailFilter, emailUpdateBody, null));
        assertEquals("the email processor cannot be null", illegalArgumentExceptionEmailProcessorNull.getMessage());

        emailProcessor.processEmails(emails, emailFilter, emailUpdateBody, processedEmail);
        Email resultEmail = emails.get(0);
        assertEquals(correctEmailResult, resultEmail);

        List<Email> emailsTestFilter = List.of(
                new Email("Welcome Letter", "Welcome to our service! We're glad to have you.", false)
        );
        Email correctEmailResultTestFilter = new Email("Welcome Letter", "Welcome to our service! We're glad to have you.", false);
        emailProcessor.processEmails(emailsTestFilter, emailFilter, emailUpdateBody, processedEmail);
        Email emailResultFilterTest = emailsTestFilter.get(0);
        assertEquals(correctEmailResultTestFilter, emailResultFilterTest);

    }
}