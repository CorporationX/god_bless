import org.junit.jupiter.api.Test;
import school.faang.gmailFilters.Email;
import school.faang.gmailFilters.EmailProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailProcessorTest {
    private static final EmailProcessor emailProcessor = new EmailProcessor();

    @Test
    public void testFunctionalityOnOneEmail() {
        // arrange
        List<Email> emails = List.of(new Email("Email from friend", "I ate cookies today.", true));

        Predicate<Email> importanceFilter = Email::isImportant;
        Function<Email, String> upperEmail = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Email is processed: " + email.getSubject());
        List<String> expected = List.of("I ATE COOKIES TODAY.");
        List<String> actual = new ArrayList<>();

        // act
        emailProcessor.processEmail(emails, importanceFilter, upperEmail, printEmail);
        emails.forEach(email -> actual.add(email.getBody()));

        // assert
        assertEquals(expected, actual, "Email should become upper case.");
    }

    @Test
    public void testFunctionalityOnMultipleEmails() {
        // arrange
        String firstEmailContent = "I ate cookies today.";
        String secondEmailContent = "Tomorrow will be an important conference!";
        String thirdEmailContent = "You have 1000 cashback bonuses.";
        String importantContent = " THIS IS AN IMPORTANT MESSAGE!";
        List<Email> emails = Arrays.asList(
                new Email("Email from friend", firstEmailContent, true),
                new Email("Email from boss", secondEmailContent, true),
                new Email("Email from bank", thirdEmailContent, true)
        );

        Predicate<Email> importanceFilter = Email::isImportant;
        Function<Email, String> upperEmail = email -> email.getBody().toUpperCase() + importantContent;
        Consumer<Email> printEmail = email -> System.out.println("Email is processed: " + email.getSubject());
        List<String> expected = List.of(firstEmailContent.toUpperCase() + importantContent,
                secondEmailContent.toUpperCase() + importantContent,
                thirdEmailContent.toUpperCase() + importantContent);
        List<String> actual = new ArrayList<>();

        // act
        emailProcessor.processEmail(emails, importanceFilter, upperEmail, printEmail);
        emails.forEach(email -> actual.add(email.getBody()));

        // assert
        assertEquals(expected, actual, "Emails should become upper case");
    }

    @Test
    public void testFilter() {
        // arrange

        List<Email> emails = List.of(new Email("Email from bank", "Send your CVV!", false));

        Predicate<Email> importanceFilter = Email::isImportant;
        Function<Email, String> upperEmail = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Email is processed: " + email.getSubject());
        List<String> expected = List.of("Send your CVV!");
        List<String> actual = new ArrayList<>();

        // act
        emailProcessor.processEmail(emails, importanceFilter, upperEmail, printEmail);
        emails.forEach(email -> actual.add(email.getBody()));

        // assert
        assertEquals(expected, actual, "Email should remain the same.");
    }
}
