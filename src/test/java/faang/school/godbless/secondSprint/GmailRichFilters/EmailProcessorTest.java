package faang.school.godbless.secondSprint.GmailRichFilters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class EmailProcessorTest {
    EmailProcessor emailProcessor;
    List<Email> emails;

    @BeforeEach
    public void setUp() {
        emailProcessor = new EmailProcessor();
        emails = List.of(
                new Email("Письмо Санте", "Хочу на новый год сырную шаву", true),
                new Email("Письмо от Мамы", "Сынок, нам нечего кушать", false),
                new Email("Срочно прочтите!", "От вас зависити судьба мира, вам нужно...", false)
        );
    }

    @Test
    public void testProcessEmailsWithoutEmailChanging() {
        Predicate<Email> predicate = email -> !email.isImportant();
        Consumer<Email> consumer = email -> System.out.println("Запускаю обработку бесполезного письма: "
                + email.getBody());
        Function<Email, Email> function = email -> new Email("Spam", "", false);

        List<Email> uselessEmails = emailProcessor.processEmails(emails, predicate, consumer, function);
        List<Email> expected = List.of(
                new Email("Spam", "", false),
                new Email("Spam", "", false)
        );

        assertEquals(expected, uselessEmails);
    }

    @Test
    public void testProcessEmailsWithEmailChanging() {
        Predicate<Email> predicate = Email::isImportant;
        Consumer<Email> consumer = email -> email.setBody(email.getBody() + "(Важно!)");
        Function<Email, Email> function = email -> new Email(email.getSubject(), email.getBody(),
                !email.isImportant());

        List<Email> uselessEmails = emailProcessor.processEmails(emails, predicate, consumer, function);
        List<Email> expected = List.of(
                new Email("Письмо Санте", "Хочу на новый год сырную шаву(Важно!)", false)
        );

        assertEquals(expected, uselessEmails);
    }
}