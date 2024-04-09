package faang.school.godbless.lambdas.task_5;

import faang.school.godbless.lambdas.task_5.model.Email;
import faang.school.godbless.lambdas.task_5.util.EmailProcessor;

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
                new Email("Спам", "Текст спама", false)
        );
        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
