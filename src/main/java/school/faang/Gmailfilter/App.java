package school.faang.Gmailfilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Meeting", "Don't forget the meeting at 10 AM.", true),
                new Email("Spam", "You've won a prize!", false),
                new Email("Reminder", "Your subscription is expiring soon.", true)
        );

        EmailProcessor emailProcessor = new EmailProcessor();

        // Лямбда-выражения для фильтрации, преобразования и обработки
        Predicate<Email> isImportant = Email::isImportant;
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Processed Email: " + email);

        // Обработка писем
        emailProcessor.processEmails(emails, isImportant, toUpperCase, printEmail);
    }
}
