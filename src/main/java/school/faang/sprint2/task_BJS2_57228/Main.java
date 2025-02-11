package school.faang.sprint2.task_BJS2_57228;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = List.of(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> filter = Email::isImportant;
        Function<Email, Email> convert = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email;
        };
        Consumer<Email> process = email -> System.out.printf("Обработано письмо: %s\n", email.getSubject());

        emailProcessor.processEmails(emails, filter, convert, process);

        System.out.println(emails);
    }
}
