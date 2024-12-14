package school.faang.moduleone.sprinttwo.task_43527;

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
                new Email("Письмо 2", "Text of the letter 2", true),
                new Email("Спам", "Текст спама", false)
        );

        // Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = email -> email.isImportant();

        // Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        // Преобразователь, который переводит текст письма в верхний регистр и сохраняет изменения
        Function<Email, Email> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email;  // Возвращает преобразованный текст
        };

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        // Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        emails.forEach(email ->
                System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}
