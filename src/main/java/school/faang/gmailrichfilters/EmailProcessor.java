package school.faang.gmailrichfilters;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> consumer, Function<Email, String> function) {
        Objects.requireNonNull(emails, "emails required");
        Objects.requireNonNull(filter, "filter required");
        Objects.requireNonNull(consumer, "consumer required");
        Objects.requireNonNull(function, "function required");

        emails.stream()
                .filter(filter)
                .peek(function::apply)
                .forEach(consumer);
    }
}
