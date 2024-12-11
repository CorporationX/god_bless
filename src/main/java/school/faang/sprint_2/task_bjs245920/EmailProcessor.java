package school.faang.sprint_2.task_bjs245920;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private final Logger log = LoggerFactory.getLogger(EmailProcessor.class);

    public void processEmails(
            List<Email> emails, Predicate<Email> filter,
            Function<Email, String> transformer, Consumer<Email> action) {

        if (emails == null || filter == null || transformer == null || action == null) {
            log.warn("Null input in method {}", "processEmails");
            throw new IllegalArgumentException("Input data cannot be null");
        }

        emails.forEach(email -> {
            if (filter.test(email)) {
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                action.accept(email);
            }
        });
    }
}
