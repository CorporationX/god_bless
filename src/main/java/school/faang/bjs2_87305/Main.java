package school.faang.bjs2_87305;

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
                new Email("Спам", "Текст спама", false),
                new Email("Рассылка", "Текст рассылки", true),
                new Email("Спам", "Текст спама", true)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> tuUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, tuUpperCase);

        System.out.println("\nОбновлённые письма:");
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject()
                + ", Тело письма: " + email.getBody()));
    }
}
