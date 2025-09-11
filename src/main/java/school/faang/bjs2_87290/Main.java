package school.faang.bjs2_87290;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Список входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Text letter 1", false),
                new Email("Letter 2", "Text letter 2", true),
                new Email("Spam", "Text spam", false)
        );

        // Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = email -> email.isImportant();

        // Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> System.out.println("\n" +
                "Message processed: " + email.getSubject());

        // Преобразователь, который переводит текст письма в верхний регистр и сохраняет изменения
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();  // Возвращает преобразованный текст
        };

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);


// Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() +
                ", Body of the letter: " + email.getBody()));
    }
}