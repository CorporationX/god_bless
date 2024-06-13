package faang.school.godbless.lambdas.gmailfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Создание списка входящих писем
        List<Email> emails = List.of(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        // 1)
        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // Обработка писем
        var result1 = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        System.out.println(result1);

        //2)
        List<Email> history = new ArrayList<>();

        Predicate<Email> containsSubjSubstrFilter = email -> email.getSubject().contains("мо");
        Consumer<Email> addToHistory = history::add;
        Function<Email, List<String>> toStringList = email -> List.of(email.getSubject(), email.getBody(), email.getSubject());

        var result2 = emailProcessor.processEmails(emails, containsSubjSubstrFilter, addToHistory, toStringList);
        System.out.println(result2);
        System.out.println(history);
    }
}
