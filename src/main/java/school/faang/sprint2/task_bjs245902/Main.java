package school.faang.sprint2.task_bjs245902;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Повышение", "Внимание, мы повысили тебе зарплату!", true),
                new Email("Мотивация", "Молодец! Так держать! Кто, если не ты? ", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email ->
                System.out.println("\nТема: " + email.getSubject() + ", \nТело письма: " + email.getBody()));
    }
}
