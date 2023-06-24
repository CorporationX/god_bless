package faang.school.godbless;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateArgument(subject);
        validateArgument(body);

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

// Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

// Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject() +
                " - " + email.getBody() + ". Оказалось ли важным: " + email.isImportant());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

    }

    private void validateArgument(String argument) {
        if (argument.isEmpty()) {
            throw new IllegalArgumentException("Argument can't be empty");
        }
    }
}
