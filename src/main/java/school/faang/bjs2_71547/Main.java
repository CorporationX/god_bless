package school.faang.bjs2_71547;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();
        Consumer<Email> printer = email ->
                System.out.println("Topic: " + email.getSubject() + '\n' + "Letter's body: " + email.getBody());

        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(emails, importantFilter, toLowerCase, printer);
    }
}
