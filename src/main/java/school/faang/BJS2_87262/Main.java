package school.faang.BJS2_87262;

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
                new Email("Письмо 3", "Текст письма 3", false),
                new Email("Письмо 4", "Текст письма 4", true),
                new Email("Письмо 5", "Текст письма 5", false),
                new Email("Письмо 6", "Текст письма 6", true),
                new Email("Письмо 7", "Текст письма 7", false),
                new Email("Письмо 8", "Текст письма 8", true),
                new Email("Письмо 9", "Текст письма 9", false),
                new Email("Письмо 10", "Текст письма 10", true),
                new Email("Письмо 11", "Текст письма 11", false),
                new Email("Письмо 12", "Текст письма 12", true),
                new Email("Спам", "Текст спама", false)
        );

        // Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = email -> email.getIsImportant();

        // Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        // Преобразователь, который переводит текст письма в верхний регистр и сохраняет изменения
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();  // Возвращает преобразованный текст
        };

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        // Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: "
                + email.getBody()));
    }
}