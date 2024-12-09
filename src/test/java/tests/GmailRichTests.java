package tests;

import org.junit.jupiter.api.Test;
import school.faang.task_45774.Email;
import school.faang.task_45774.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class GmailRichTests {
    private static final EmailProcessor EMAIL_PROCESSOR = new EmailProcessor();
    private static final List<Email> EMAILS = Arrays.asList(
            new Email("Email 1", "Text 1", false),
            new Email("Email 2", "Text 2", true),
            new Email("Spam", "Spam text", false)
    );

    @Test
    void testPositiveOfFilters() {
        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> {
            String message = "Print email: " + email.getSubject();
            System.out.println(message);
        };

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        List<Email> importantEmails = EMAIL_PROCESSOR.predicateList(EMAILS, importantFilter);
        EMAIL_PROCESSOR.consumeList(importantEmails, printEmail);
        EMAIL_PROCESSOR.functionList(importantEmails, toUpperCase);
    }

    @Test
    void testFilterNoFindResult() {
        Predicate<Email> importantFilter = email -> email.getSubject().contains("What?");
        List<Email> importantEmails = EMAIL_PROCESSOR.predicateList(EMAILS, importantFilter);
    }

    @Test
    void testConsumeToAllEmails() {
        Consumer<Email> printEmail = email -> email.setImportant(false);
        EMAIL_PROCESSOR.consumeList(EMAILS, printEmail);
    }

    @Test
    void testBlankList() {
        List<Email> emptyEmails = List.of();

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> {
            String message = "Print email: " + email.getSubject();
            System.out.println(message);
        };

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        List<Email> importantEmails = EMAIL_PROCESSOR.predicateList(emptyEmails, importantFilter);
        EMAIL_PROCESSOR.consumeList(importantEmails, printEmail);
        EMAIL_PROCESSOR.functionList(importantEmails, toUpperCase);
    }
}
