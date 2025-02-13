package scool.faang.sprint.second.gmail;

import org.junit.Test;
import org.mockito.Mockito;
import school.faang.sprint.second.gmail.Email;
import school.faang.sprint.second.gmail.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class TestEmailProcessor {
    @Test
    public void testProcessEmails() {
        EmailProcessor emailProcessor = Mockito.spy(EmailProcessor.class);
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
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        Mockito.verify(emailProcessor, Mockito.times(1))
                .processEmails(emails, importantFilter, printEmail, toUpperCase);
    }

    @Test(expected = NullPointerException.class)
    public void testProcessNullEmails() {
        EmailProcessor emailProcessor = Mockito.spy(EmailProcessor.class);

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };
        emailProcessor.processEmails(null, importantFilter, printEmail, toUpperCase);
    }

    @Test()
    public void testProcessEmailsWithAnotherProcessLogic() {
        EmailProcessor emailProcessor = Mockito.spy(EmailProcessor.class);
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> notImportantEmail = (email) -> !email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getBody());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(null);
            return email.getBody();
        };
        emailProcessor.processEmails(emails, notImportantEmail, printEmail, toUpperCase);

        Mockito.verify(emailProcessor, Mockito.times(1))
                .processEmails(emails, notImportantEmail, printEmail, toUpperCase);
    }
}
