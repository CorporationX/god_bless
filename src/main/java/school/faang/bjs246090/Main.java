package school.faang.bjs246090;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = List.of(
                new Email("просьба", "дать доступы к стендам", true),
                new Email("реклама", "скидки 99999999%", false),
                new Email("скам", "купи shitCoin", false));

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        EmailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        emails.forEach(System.out::println);
    }
}
