package school.faang.Gmailfilter;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transform,
                              Consumer<Email> processor) {

        Objects.requireNonNull(emails, "Email list cannot be null");
        Objects.requireNonNull(filter, "Filter cannot be null");
        Objects.requireNonNull(transform, "Transformation function cannot be null");
        Objects.requireNonNull(processor, "Processor cannot be null");

        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = transform.apply(email);
                email = new Email(email.getSubject(), transformedBody, email.isImportant());
                processor.accept(email);
            }
        }
    }
}
