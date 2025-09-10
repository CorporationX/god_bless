package school.faang.bjs2_87274;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
            new Email("Письмо 1", "Текст письма 1", true),
            new Email("Письмо 2", "Текст письма 2", true),
            new Email("Спам", "Текст спама", false)
        );
        Predicate<Email> importantEmailFilter = (email) -> email.isImportant();
        Function<Email, String> toUpperCase = (email) -> email.getBody().toUpperCase();
        Consumer<Email> handledEmail = (email) -> System.out.println("Обработано письмо: " + email.getSubject());

        EmailProcessor.processEmails(emails, importantEmailFilter, toUpperCase, handledEmail);

        emails.forEach(email ->
                System.out.println("Тема письма: " + email.getSubject() + " Содержание: " + email.getBody()));
    }
}
