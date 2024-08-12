package faang.school.godbless.task.lambda.gmail.rich.filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println(email));

        // Фильтр спама
        Predicate<Email> spamFilter = email -> email.getSubject().equals("Спам");
        Consumer<Email> printSpamEmail = email ->
                System.out.println("Это письмо спам: " + email.getSubject());
        Function<Email, String> hideBody = email ->
                email.getBody().replaceAll("[\\w\\p{IsCyrillic}+]", "*");

        // Обработка писемь на наличие спама
        emailProcessor.processEmails(emails, spamFilter, printSpamEmail, hideBody);

        emails.forEach(email -> System.out.println(email));
    }
}
