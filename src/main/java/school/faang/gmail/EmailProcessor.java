package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer,
                                                                                Function<Email, String> function) {
        emails.stream()
                .filter(predicate)
                .peek(email -> email.setBody(function.apply(email)))
                .forEach(email -> consumer.accept(email));
    }
}