package school.faang.bjs2_70440;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = List.of(
                new Email("Work", "You have to go to work, man", true),
                new Email("F4-E", "You have to learn the startUp procedure", true),
                new Email("Spam", "You have to buy stuff from us", false),
                new Email("InfoGypsy", "You have to reflect on the universe", false)
        );
        Function<Email, String> upperCaser = email -> email.getBody().toUpperCase();
        Predicate<Email> importanceChecker = Email::isImportant;
        Consumer<Email> processedEmail = email -> {
            System.out.printf("Email with subject %s is being processed\n", email.getSubject());
        };

        emailProcessor.processEmails(emails, importanceChecker, upperCaser, processedEmail);
    }
}
