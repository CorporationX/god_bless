package school.faang.gmail_reach_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> function,
                                     Consumer<Email> consumer) {
        emails.forEach(consumer);
        return emails.stream()
                .filter(filter)
                .peek(email -> email.setBody(function.apply(email)))
                .toList();
    }
}
