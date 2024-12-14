package faang.school.godbless.gmailrichfilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String... args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Text of letter 1", true),
                new Email("Letter 2", "Text of letter 2", true),
                new Email("Spam", "Text of spam", false)
        );
        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> email.isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Processed letter: " + email.subject);
        Function<Email, String> toUpperCase = email -> email.body.toUpperCase();

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

    }
}
