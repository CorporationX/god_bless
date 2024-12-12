package school.faang.bjs_45873;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EmailProcessorTest {

    @Test
    void processEmails() {
        List<Email> emails = getSourceEmails();
        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Processed email: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        List<Email> actualEmails = emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        Assertions.assertEquals(getExceptedEmails().size(), actualEmails.size());
        Assertions.assertTrue(getExceptedEmails().containsAll(actualEmails));
    }

    @Test
    void processNullableEmails() {
        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Processed email: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                emailProcessor.processEmails(null, importantFilter, toUpperCase, printEmail));
    }

    @Test
    void processNullableFilter() {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = getSourceEmails();
        Consumer<Email> printEmail = email -> System.out.println("Processed email: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                emailProcessor.processEmails(emails, null, toUpperCase, printEmail));
    }

    @Test
    void processNullableProcessor() {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = getSourceEmails();

        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                emailProcessor.processEmails(emails, importantFilter, toUpperCase, null));
    }

    @Test
    void processNullableConverter() {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = getSourceEmails();
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Processed email: " + email.getSubject());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                emailProcessor.processEmails(emails, importantFilter, null, printEmail));
    }

    private List<Email> getSourceEmails() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Email 1", false, "The text of the letter 1"));
        emails.add(new Email("Email 2", true, "The text of the letter 2"));
        emails.add(new Email("Spam", false, "The text of the spam"));
        return emails;
    }

    private List<Email> getExceptedEmails() {
        return List.of(new Email("Email 2", true, "THE TEXT OF THE LETTER 2"));
    }
}