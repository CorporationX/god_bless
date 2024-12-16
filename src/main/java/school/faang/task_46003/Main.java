package school.faang.task_46003;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        try {
            List<Email> emails = Arrays.asList(
                    new Email("Письмо 1", "Текст письма 1", false),
                    new Email("Письмо 2", "Текст письма 2", true),
                    new Email("Спам", "Текст спама", false)
            );

            Predicate<Email> importantFilter = Email::isImportant;

            Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

            Function<Email, String> toUpperCase = email -> {
                email.setBody(email.getBody().toUpperCase());
                return email.getBody();  // Возвращает преобразованный текст
            };

            emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

            emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }

        }
}
