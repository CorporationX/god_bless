package school.faang.gmail.rich.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public static void processEmails(
            List<Email> emails,
            Predicate<Email> predicate,
            Function<Email, String> function,
            Consumer<Email> consumer) {
        emails.stream()
                .filter(predicate)
                .peek(email -> email.setBody(function.apply(email)))
                .forEach(consumer);
    }
}
