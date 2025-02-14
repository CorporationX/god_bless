package gmail;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> processor, Function<Email, String> transformer) {
        Objects.requireNonNull(emails, "List of emails cannot be null.");
        Objects.requireNonNull(filter, "Filter cannot be null.");
        Objects.requireNonNull(processor, "Processor cannot be null.");
        Objects.requireNonNull(transformer, "Transformer cannot be null.");

        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                processor.accept(email);
            }
        }
    }
}
