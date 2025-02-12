package gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private void validateInput(Object value, String errorMessage) {
        if (value == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> processor, Function<Email, String> transformer) {
        validateInput(emails, "List of emails cannot be null.");
        validateInput(filter, "Filter cannot be null.");
        validateInput(processor, "Processor cannot be null.");
        validateInput(transformer, "Transformer cannot be null.");

        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                processor.accept(email);
            }
        }
    }
}
