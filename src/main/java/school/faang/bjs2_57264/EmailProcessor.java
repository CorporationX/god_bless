package school.faang.bjs2_57264;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> function, Consumer<Email> consumer) {
        validatePredicate(filter);
        validateFunction(function);
        validateConsumer(consumer);
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(function.apply(email));
                consumer.accept(email);
            }
        }
    }

    private void validatePredicate(Predicate<Email> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate is null");
        }
    }

    private void validateFunction(Function<Email, String> function) {
        if (function == null) {
            throw new IllegalArgumentException("Function is null");
        }
    }

    private void validateConsumer(Consumer<Email> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("Consumer is null");
        }
    }
}
