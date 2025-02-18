package school.faang.bjs2_57506;

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

        // Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = Email::isImportant;

        // Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        // Преобразователь, который переводит текст письма в верхний регистр и сохраняет изменения
        Function<Email, String> toUpperCase = email -> {
            return email.getBody().toUpperCase();  // Возвращает преобразованный текст
        };

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        // Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        emails.forEach(email ->
            System.out.printf("Тема: %s, Тело письма: %s%n", email.getSubject(), email.getBody())
        );
    }
}
