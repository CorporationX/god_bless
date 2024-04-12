package faang.school.godbless.module.second.lambda.gmail;

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
            new Email("Письмо 2", "Текст письма 2", true),
            new Email("Спам", "Текст спама", false)
        );
        
        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<String> printEmail = convertedString -> System.out.println("Обработано письмо: " + convertedString);
        Function<Email, String> toUpperCase = email -> String.format(
            "Конвертировали в строку %s с телом %s",
            email.getSubject(),
            email.getBody().toUpperCase()
        );
        
        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
    }
}
