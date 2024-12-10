package school.faang.gmail_filters;

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
                new Email("Email 1", "Email text 1", false),
                new Email("Email 2", "Email text 2", true),
                new Email("Спам", "Текст спама", false)
        );

// Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = Email::isImportant;

// Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

// Преобразователь, который переводит текст письма в верхний регистр
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emails = emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

// Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        emails.forEach(
                email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody())
        );
    }
}
