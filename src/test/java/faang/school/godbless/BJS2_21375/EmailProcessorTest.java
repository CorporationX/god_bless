package faang.school.godbless.BJS2_21375;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EmailProcessorTest {
    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();
    private EmailProcessor emailProcessor;
    private List<Email> emails;

    @BeforeEach
    void setUp() {
        emailProcessor = new EmailProcessor();
        emails = new ArrayList<>(
                List.of(
                        new Email("Привет", "Просто скажи привет!", true),
                        new Email("Project Update", "Here's the latest update on the project.", false),
                        new Email("Meeting Invitation", "You're invited to a meeting tomorrow.", true),
                        new Email("Discount Offer", "Get 50% off your next purchase!", false)
                )
        );

        System.setOut(new PrintStream(OUTPUT_STREAM_CAPTOR));
    }

    @Test
    void processEmails() {
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        String expectedOut = """
                Обработано письмо: Привет
                Обработано письмо: Meeting Invitation""";

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        Assertions.assertThat(normalize(OUTPUT_STREAM_CAPTOR.toString())).isEqualTo(expectedOut);
    }

    private String normalize(String input) {
        return input.strip().replaceAll("\\r+", "");
    }
}