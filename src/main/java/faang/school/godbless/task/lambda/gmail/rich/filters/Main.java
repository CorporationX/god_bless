package faang.school.godbless.task.lambda.gmail.rich.filters;

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

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println(email));

        Predicate<Email> spamFilter = email -> email.getSubject().equals("Спам");
        Consumer<Email> printSpamEmail = email ->
                System.out.println("Это письмо спам: " + email.getSubject());
        Function<Email, String> hideBody = email ->
                email.getBody().replaceAll("[\\w\\p{IsCyrillic}+]", "*");

        emailProcessor.processEmails(emails, spamFilter, printSpamEmail, hideBody);

        emails.forEach(email -> System.out.println(email));
    }
}
