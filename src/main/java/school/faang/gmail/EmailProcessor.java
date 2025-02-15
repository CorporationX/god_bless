package school.faang.gmail;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> incomingMessages, Predicate<Email> filter,
                             Function<Email, String> transformer, Consumer<Email> action) {
        Objects.requireNonNull(incomingMessages);
        Objects.requireNonNull(filter);
        Objects.requireNonNull(transformer);
        Objects.requireNonNull(action);
        for (Email email : incomingMessages) {
            if (filter.test(email)) {
                String resultEmailBody = transformer.apply(email);
                email.setBody(resultEmailBody);
                action.accept(email);
            }
        }
    }
}
