package faang.school.godbless.lambda.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        System.out.println("emails: " + emails);

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email);
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        List<Email> processedEmails = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        System.out.println("processedEmails: " + processedEmails);
    }
}
