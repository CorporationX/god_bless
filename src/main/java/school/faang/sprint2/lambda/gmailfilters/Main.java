package school.faang.sprint2.lambda.gmailfilters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

// Список входящих писем
        List<Email> emails = new ArrayList<>(Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false),
                new Email("Письмо 3", "Текст письма 3", true),
                new Email("Письмо 4", "Текст письма 4", true),
                new Email("Спам2", "Текст спама2", true)
        ));

// Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = email -> email.isImportant();

// Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

// Преобразователь, который переводит текст письма в верхний регистр
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

// Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        System.out.println(">>>>>>");
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}
