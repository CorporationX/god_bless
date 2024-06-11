package faang.school.godbless.lamdbastreamapi.gmail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Email> emails = new ArrayList<>(Arrays.asList(
            new Email("Письмо 1", "Текст письма 1", false),
            new Email("Письмо 2", "Текст письма 2", true),
            new Email("Спам", "Текст спама", false)
        ));

        EmailProcessor emailProcessor = new EmailProcessor();
        Predicate<Email> importantFilter = (email) -> {
            if (email.isImportant()) {
                System.out.println("Письмо " + email.subject() + " - важное");
            }
            return email.isImportant();
        };
        Consumer<Email> printEmail = (email) -> System.out.println("Обработано письмо: " + email.subject());
        Function<Email, String> toUpperCase = (email) -> email.body().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
