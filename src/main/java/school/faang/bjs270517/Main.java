package school.faang.bjs270517;


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
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        // Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = email -> email.isImportant();

        // Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        // Преобразователь, который переводит текст письма в верхний регистр
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        // Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        emails.forEach(email
                -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}
