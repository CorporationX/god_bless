package school.faang;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Function<Email, String> transformer, Consumer<Email> action) {
        validatePredicate(predicate);
        validateFunction(transformer);
        validateConsumer(action);
        for (Email email : emails) {
            if (predicate.test(email)) {
                email.setBody(transformer.apply(email));
                action.accept(email);
            }
        }
    }

    private void validatePredicate(Predicate<Email> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("The predicate can't be null.");
        }
    }

    private void validateFunction(Function<Email, String> function) {
        if (function == null) {
            throw new IllegalArgumentException("The function can't be null.");
        }
    }

    private void validateConsumer(Consumer<Email> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("The consumer can't be null.");
        }
    }
}
