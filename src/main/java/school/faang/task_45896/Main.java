package school.faang.task_45896;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
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

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> isImportantFilter = email -> email.isImportant();

        Consumer<Email> printTopicOfImportantEmail = email -> System.out.println(email.subject());


        Function<Email, String> returnEmailToUpperCase = email -> email.body().toUpperCase(Locale.ROOT);

        emailProcessor.processEmails(emails, isImportantFilter, printTopicOfImportantEmail, returnEmailToUpperCase);

        emails.forEach(email -> System.out.println("Тема: " + email.subject() + ", Тело письма: " + email.body()));
    }
}
