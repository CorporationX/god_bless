package gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> predicate,
            Function<Email, String> transformer,
            Consumer<Email> consumer
    ) {
        if (emails == null) {
            throw new IllegalArgumentException("Email list must not be null");
        }

        emails.stream()
                .filter(predicate)
                .peek(consumer)
                .map(transformer)
                .forEach(System.out::println);
    }
}
