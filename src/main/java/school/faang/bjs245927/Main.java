package school.faang.bjs245927;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        final EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = new ArrayList<>(List.of(
                new Email("Is very important", "You won a IPHONE in our lottery", true),
                new Email("Buy product", "We have problem with delivery, please call me at the number", true),
                new Email("Spam", "Something body of the latter...", false)));

        Predicate<Email> emailImportant = (email -> email.isImportant());
        Function<Email, String> transformationBody = (email -> email.getBody().toUpperCase());
        Consumer<Email> handlerLatter =
                (email -> System.out.println("The latter has been processed: " + email.getSubject()));

        emailProcessor.processEmail(emails, emailImportant, transformationBody, handlerLatter);
        emails.forEach(email ->
                System.out.println("Subject: " + email.getSubject() + ", Body latter: " + email.getBody()));
    }
}
