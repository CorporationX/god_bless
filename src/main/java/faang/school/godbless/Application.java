package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
    public static void main(String... args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Message 1", "Text of message 1", false),
                new Email("Message 2", "Text of message 2", true),
                new Email("Spam", "Text of spam", false)
        );

        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> printEmail = email -> "Messages: " + email.getSubject();
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // Обработка писем
        List<String> filteredEmails = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        for(String email : filteredEmails){
            System.out.println(email);
        }
    }
}
