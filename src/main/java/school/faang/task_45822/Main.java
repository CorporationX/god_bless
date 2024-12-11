package school.faang.task_45822;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final EmailProcessor emailProcessor = new EmailProcessor();

    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        // Фильтр, который пропускает только важные письма
        Predicate<Email> importantFilter = Email::isImportant;

        // Преобразователь, который переводит текст письма в верхний регистр
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> logger.info("Обработано письмо: {}", email.getSubject());

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        // Выводим обновленные письма, чтобы убедиться, что изменения сохранились
        emails.forEach(email ->
                logger.info("Тема: {}, Тело письма: {}", email.getSubject(), email.getBody()));
    }

}
