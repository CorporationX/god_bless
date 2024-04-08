package faang.school.godbless.BJS2_4997;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Message 1", "The pizza is cooked. Pick up the order", true),
                new Email("Message 2", "The order has arrived at the pick up point", false),
                new Email("Message 3", "Enrollment termination order", true));

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.printf("Обработано письмо: %s %s %n", email.getSubject(), email.getBody());
        Function<Email, Email> toUpperCase = email -> {
            String upperCaseBody = email.getBody().toUpperCase();
            return new Email(email.getSubject(), upperCaseBody, email.isImportant());
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}