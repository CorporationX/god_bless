package BJS257244;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        EmailProcessor emailProcessor = new EmailProcessor();

        // Список входящих писем
        List<Email> emails = Arrays.asList(
                new Email("First Message", "text for first message", false),
                new Email("Second Message", "text for second message", true),
                new Email("Third Message", "text for third message", false),
                new Email("Forth Message", "text for forth message", true)
        );

        // фильтр на важные письма
        Predicate<Email> importantFilter = email -> email.isImportant();

        // Обработчик писем
        Consumer<Email> printEmail = email -> System.out.println("Message : " + email.getSubject());

        // Преобразовывает письма в верхний регистр
        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        // Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        // Вывод измененных писем
        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() +
                ", message text: " + email.getBody()));


    }
}
