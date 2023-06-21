package Gmail_Rich_Filters;

import java.util.ArrayList;
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
        Predicate<Email> unimportantFilter = email -> !email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Function<Email,String> toUpperCaseInEmailObject = email -> {
            String result = email.getBody().toUpperCase();
            email.setBody(result);
            return result;
        };

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        System.out.println("------------------------------------");
        emailProcessor.processEmails(emails, unimportantFilter, printEmail, toUpperCase);
        System.out.println("------------------------------------");
        List<Email> emails2 = new ArrayList<>();
        emails2 = emailProcessor.processEmailsToNewList(emails, importantFilter, printEmail, toUpperCaseInEmailObject);
        System.out.println(emails2);
        System.out.println("------------------------------------");
        List<Email> emails3 = new ArrayList<>();
        emails3 = emailProcessor.processEmailsToNewList(emails, unimportantFilter, printEmail, toUpperCaseInEmailObject);
        System.out.println(emails3);

    }
}
