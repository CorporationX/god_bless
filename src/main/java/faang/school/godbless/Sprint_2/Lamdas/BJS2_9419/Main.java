package faang.school.godbless.Sprint_2.Lamdas.BJS2_9419;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Tawdadwawdawdwa", true),
                new Email("Письмо 3", "zcxkkpmcpsddcs", true),
                new Email("Спам", "Текст спама", false)
        );
        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject() + " : Результат обратобки: " + email.getBody());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

    }
}
