package school.faang.sprint_2.task_45935;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Objects;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> processor,
                              Function<Email, String> transformer) {
        Objects.requireNonNull(emails, "Emails dont null");
        Objects.requireNonNull(filter, "Filter dont null");
        Objects.requireNonNull(processor, "Processor dont null");
        Objects.requireNonNull(transformer, "Transformer dont null");

        emails.stream()
                .filter(filter)
                .peek(email -> email.setBody(transformer.apply(email)))
                .forEach(processor);
    }
}