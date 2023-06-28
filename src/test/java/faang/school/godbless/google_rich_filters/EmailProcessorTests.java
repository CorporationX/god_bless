package faang.school.godbless.google_rich_filters;

import faang.school.godbless.gmail_rich_filters.Email;
import faang.school.godbless.gmail_rich_filters.EmailHandler;
import faang.school.godbless.gmail_rich_filters.EmailProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailProcessorTests {

    private EmailProcessor emailProcessor;

    private List<Email> emailList;

    private EmailHandler importantMessagesHandler;
    private EmailHandler garbageMessagesHandler;
    private EmailHandler secretMessagesHandler;

    @BeforeEach
    public void setUp() {
        emailProcessor = new EmailProcessor();

        Email offer = Email.builder()
                .isImportant(true)
                .subject("Job offer")
                .body("Congratulations - You've been selected by FAANG")
                .build();

        Email invite = Email.builder()
                .isImportant(true)
                .subject("Let's have a party!")
                .body("Hey hey! We're waiting for you!")
                .build();

        Email spam = Email.builder()
                .isImportant(false)
                .subject("Enlarge your...")
                .body("Only this weekend 70% off for our special cream!")
                .build();

        emailList = List.of(offer, invite, spam);

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("Email processed: " + email.getSubject());
        Consumer<Email> deleteEmail = email -> System.out.println("Email deleted: " + email.getSubject());
        Consumer<Email> encryptEmail = email -> System.out.println("Email encrypted: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();
        Function<Email, String> toCypher = email -> Arrays.toString(email.getBody().getBytes());

        importantMessagesHandler = EmailHandler.builder()
                .filter(importantFilter)
                .processor(printEmail)
                .converter(toUpperCase)
                .build();

        garbageMessagesHandler = EmailHandler.builder()
                .filter(importantFilter)
                .processor(deleteEmail)
                .converter(toLowerCase)
                .build();

        secretMessagesHandler = EmailHandler.builder()
                .filter(importantFilter)
                .processor(encryptEmail)
                .converter(toCypher)
                .build();
    }

    @Test
    @DisplayName("Should process important emails")
    public void shouldProcessImportantEmails() {
        List<String> capitalizedEmailBodies = emailList.stream().map(email -> email.getBody().toUpperCase()).toList();

        emailProcessor.processEmails(emailList, importantMessagesHandler);

        List<String> actualEmailBodies = emailList.stream().map(Email::getBody).toList();

        assertEquals(capitalizedEmailBodies, actualEmailBodies);
    }

    @Test
    @DisplayName("Should process secret emails")
    public void shouldProcessSecretEmails() {
        List<String> encryptedEmailBodies = emailList.stream().map(email ->
                Arrays.toString(email.getBody().getBytes())).toList();

        emailProcessor.processEmails(emailList, secretMessagesHandler);

        List<String> actualEmailBodies = emailList.stream().map(Email::getBody).toList();

        Assertions.assertEquals(encryptedEmailBodies, actualEmailBodies);
    }

    @Test
    @DisplayName("Should process garbage emails")
    public void shouldProcessGarbageEmails() {
        List<String> loweredEmailBodies = emailList.stream().map(email -> email.getBody().toLowerCase()).toList();

        emailProcessor.processEmails(emailList, garbageMessagesHandler);

        List<String> actualEmailBodies = emailList.stream().map(Email::getBody).toList();

        Assertions.assertEquals(loweredEmailBodies, actualEmailBodies);
    }
}
