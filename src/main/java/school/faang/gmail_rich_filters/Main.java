package school.faang.gmail_rich_filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailprocessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantfilter = Email::isImportant;

        Function<Email, String> toUppercase = email -> email.getBody().toUpperCase();

        Consumer<Email> printemail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        emailprocessor.processEmails(emails, importantfilter, toUppercase, printemail);

        System.out.println("\n=== Обновленные письма ===");
        emails.forEach(email ->
                System.out.println("Тема: " + email.getSubject() + ", Тело: " + email.getBody())
        );
    }
}
