package faang.school.godbless.BJS2_21342;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = new ArrayList<>(List.of(
                new Email("Letter 1", "Dancing doughnuts...", true),
                new Email("Letter 2", "Gigantic giraffes...", false),
                new Email("Letter 3", "", false),
                new Email("Letter 4", "Bouncing bananas...", true),
                new Email("Letter 5", "Ticklish Turtles...", false)
        ));

        Predicate<Email> EmptyBody = (email) -> email.getBody().isBlank();
        Function<Email, String> toUpperCaseString = (email) -> email.getSubject().toUpperCase() + ": " + email.getBody().toUpperCase();
        Consumer<Email> allIsImportant = (email) -> email.setImportant(true);

        emailProcessor.processEmails(emails, EmptyBody, toUpperCaseString, allIsImportant);
        emails.forEach(System.out::println);
    }

}
