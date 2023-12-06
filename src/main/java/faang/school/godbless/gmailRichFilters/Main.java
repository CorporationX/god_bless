package faang.school.godbless.gmailRichFilters;

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
        Predicate<Email> emailPredicate = email -> email.isImportant();
        Consumer<Email> emailConsumer = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, Email> emailFunction = email -> new Email(email.getSubject().toUpperCase(), email.getBody().toLowerCase(), email.isImportant());

        // Обработка писем
        List<Email> test = EmailProcessor.processEmails(emails, emailPredicate, emailConsumer, emailFunction);
    }
}
