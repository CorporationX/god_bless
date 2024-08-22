package faang.school.godbless.gmail.rich.filters;

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
                new Email("Letter 1", "Text of letter 1", false),
                new Email("Letter 2", "Text of letter 2", true),
                new Email("Spam", "Text of spam", false)
        );

        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, Email> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email;
        };
        Consumer<Email> printEmail = email -> System.out.println("Letter handled: " + email);

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);


        // Создание фильтров, обработчиков и преобразователей
        Predicate<Email> unimportantFilter = email -> !email.isImportant();
        Function<Email, Email> addInfo = email -> {
            email.setSubject(email.getSubject() + "---unimportant---");
            return email;
        };

        // Обработка писем
        emailProcessor.processEmails(emails, unimportantFilter, printEmail, addInfo);
    }
}
