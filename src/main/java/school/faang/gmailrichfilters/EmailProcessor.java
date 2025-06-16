package school.faang.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Function<Email, String> transformer,
            Consumer<Email> action) {
        emails.stream()
                .filter(filter)
                .peek(email -> email.setBody(transformer.apply(email)))
                .forEach(action);
    }
}
