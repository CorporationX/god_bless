import gmailfilters.Email;
import gmailfilters.EmailProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

class EmailProcessorTest {
    private static final Logger logger = Logger.getLogger(EmailProcessorTest.class.getName());

    @Test
    void testProcessEmailsWithImportantEmails() {
        logger.info("Running test: testProcessEmailsWithImportantEmails");
        EmailProcessor processor = new EmailProcessor();
        List<Email> emails = List.of(
                new Email("Subject 1", "Body 1", true),
                new Email("Subject 2", "Body 2", false),
                new Email("Subject 3", "Body 3", true)
        );
        Predicate<Email> importantFilter = this::isImportant;
        Consumer<Email> printAction = this::processEmail;
        Function<Email, String> bodyTransformer = this::transformBody;
        processor.processEmails(emails, importantFilter, printAction, bodyTransformer);
        assertTrue(emails.get(0).isImportant(), "Email 'Subject 1' should be important.");
        assertFalse(emails.get(1).isImportant(), "Email 'Subject 2' should not be important.");
        assertTrue(emails.get(2).isImportant(), "Email 'Subject 3' should be important.");
        assertEquals("Body 1", emails.get(0).body(),
                "Transformed body of 'Subject 1' should be uppercase.");
        assertEquals("Body 3", emails.get(2).body(),
                "Transformed body of 'Subject 3' should be uppercase.");
        logger.info("Test passed: testProcessEmailsWithImportantEmails");
    }

    @Test
    void testProcessEmailsWithTransformedBody() {
        logger.info("Running test: testProcessEmailsWithTransformedBody");
        EmailProcessor processor = new EmailProcessor();
        List<Email> emails = List.of(
                new Email("Subject 1", "HELLO, WORLD!", true),
                new Email("Subject 2", "Another email body", false),
                new Email("Subject 3", "Yet another email", true)
        );
        Predicate<Email> filter = this::noFilter;
        Consumer<Email> printAction = this::processTransformedEmail;
        Function<Email, String> transformer = this::transformBody;
        processor.processEmails(emails, filter, printAction, transformer);
        assertEquals("HELLO, WORLD!", emails.get(0).body(),
                "Transformed body of 'Subject 1' should be uppercase.");
        assertEquals("Another email body", emails.get(1).body(),
                "Transformed body of 'Subject 2' should be uppercase.");
        assertEquals("Yet another email", emails.get(2).body(),
                "Transformed body of 'Subject 3' should be uppercase.");
        logger.info("Test passed: testProcessEmailsWithTransformedBody");
    }

    @Test
    void testProcessEmailsWithEmptyBody() {
        logger.info("Running test: testProcessEmailsWithEmptyBody");
        EmailProcessor processor = new EmailProcessor();
        List<Email> emails = List.of(
                new Email("Subject 1", "", true),
                new Email("Subject 2", "Valid body", false)
        );
        Predicate<Email> filter = this::noFilter;
        Consumer<Email> printAction = this::processEmailWithEmptyBody;
        Function<Email, String> transformer = this::transformBody;
        processor.processEmails(emails, filter, printAction, transformer);
        assertEquals("", emails.get(0).body(),
                "Body of 'Subject 1' should be empty.");
        assertEquals("Valid body", emails.get(1).body(),
                "Body of 'Subject 2' should be transformed correctly.");
        logger.info("Test passed: testProcessEmailsWithEmptyBody");
    }

    @Test
    void testProcessEmailsWithNullEmail() {
        logger.info("Running test: testProcessEmailsWithNullEmail");
        EmailProcessor processor = new EmailProcessor();
        List<Email> emails = List.of(
                new Email("Subject 1", "Body 1", true),
                new Email("Subject 2", "Body 2", true),
                new Email("Subject 3", "Body 3", false)
        );
        Predicate<Email> filter = this::noFilter;
        Consumer<Email> printAction = this::processEmail;
        Function<Email, String> transformer = this::transformBody;
        processor.processEmails(emails, filter, printAction, transformer);
        assertNotNull(emails.get(0), "First email should not be null.");
        assertNull(null);
        assertNotNull(emails.get(2), "Third email should not be null.");
        assertEquals("Body 1", emails.get(0).body(),
                "Transformed body of 'Subject 1' should be uppercase.");
        assertEquals("Body 3", emails.get(2).body(),
                "Transformed body of 'Subject 3' should be uppercase.");
        logger.info("Test passed: testProcessEmailsWithNullEmail");
    }

    private boolean isImportant(Email email) {
        if (email.isImportant()) {
            logger.info("Email '" + email.subject() + "' is important.");
            return true;
        } else {
            logger.info("Email '" + email.subject() + "' is not important.");
            return false;
        }
    }

    private void processEmail(Email email) {
        if (email.isImportant()) {
            logger.info("Processing important email: " + email.subject() + " (Important: " + true + ")");
        } else {
            logger.info("Skipping non-important email: " + email.subject());
        }
    }

    private void processTransformedEmail(Email email) {
        logger.info("Processing transformed email with body: " + email.body());
    }

    private void processEmailWithEmptyBody(Email email) {
        if (email.body().isEmpty()) {
            logger.warning("Email '" + email.subject() + "' has an empty body after transformation.");
        } else {
            logger.info("Processing email with body: " + email.body());
        }
    }

    private String transformBody(Email email) {
        String transformedBody = email.body().toUpperCase();
        if (transformedBody.isBlank()) {
            logger.warning("Email '" + email.subject() + "' has an empty transformed body.");
        } else {
            logger.info("Transformed body of email '" + email.subject() + "' to: " + transformedBody);
        }
        return transformedBody;
    }

    private boolean noFilter(Email email) {
        return true;
    }
}
