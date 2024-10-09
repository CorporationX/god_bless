package bjs2_33600;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(
            List<Email> emails,
            Predicate<Email> predicate,
            Consumer<Email> consumer,
            Function<Email, Email> function
    ) {
        return emails
                .stream()
                .filter(predicate)
                .peek(consumer)
                .map(function)
                .toList();
    }
}
