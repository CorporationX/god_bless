package school.faang.functional_interfaces_lambdas.gmail_rich_filters_bjs2_87262;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Письмо 3", "Текст письма 3", false),
                new Email("Письмо 4", "Текст письма 4", true),
                new Email("Письмо 5", "Текст письма 5", false),
                new Email("Письмо 6", "Текст письма 6", true),
                new Email("Письмо 7", "Текст письма 7", false),
                new Email("Письмо 8", "Текст письма 8", true),
                new Email("Письмо 9", "Текст письма 9", false),
                new Email("Письмо 10", "Текст письма 10", true),
                new Email("Письмо 11", "Текст письма 11", false),
                new Email("Письмо 12", "Текст письма 12", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = email -> email.getIsImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: "
                + email.getBody()));
    }
}