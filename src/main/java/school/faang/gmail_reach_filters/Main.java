package school.faang.gmail_reach_filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", true),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmailSubject = email -> System.out.println("Письмо получено обработчиком: " +
                email.getSubject());
        Function<Email, String> signatureFunction = email -> email.getBody().concat("\nSignature");

        List<Email> emailsList = emailProcessor.processEmails(emails, importantFilter, signatureFunction,
                printEmailSubject);
        emailsList.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма с подписью: " +
                email.getBody()));
    }
}
