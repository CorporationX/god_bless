package school.faang.gmailrichfilters;

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
                new Email("Письмо 3", "Текст письма 3", true),
                Email.builder()
                        .subject("Спам")
                        .body("Текст спама")
                        .isImportant(false)
                        .build(),
                Email.builder()
                        .subject("Спам2")
                        .body("Текст спама2")
                        .build(),
                Email.builder()
                        .body("Текст спама3")
                        .build()
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() +
                ", Тело письма: " + email.getBody()));
    }
}
