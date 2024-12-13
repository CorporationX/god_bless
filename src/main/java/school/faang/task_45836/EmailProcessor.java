package school.faang.task_45836;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> transformer) {

        if (emails == null || filter == null || action == null || transformer == null) {
            throw new IllegalArgumentException("One or more arguments are null");
        }

        emails.stream()
                .filter(Objects::nonNull)
                .filter(filter)
                .peek(email -> email.setBody(transformer.apply(email)))
                .forEach(action);
    }
}