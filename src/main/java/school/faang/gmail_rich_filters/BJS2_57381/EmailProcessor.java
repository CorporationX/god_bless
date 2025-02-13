package school.faang.gmail_rich_filters.BJS2_57381;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailProcessor.class);

    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Function<Email, String> transformer,
            Consumer<Email> postProcessor) {

        validateForNull(emails == null, "emails is null");
        validateForNull(filter == null, "filter is null");
        validateForNull(transformer == null, "transformer is null");
        validateForNull(postProcessor == null, "postProcessor is null");

        LOGGER.info("Processing emails " + emails.size() + " emails");

        emails.stream().filter(filter).forEach(email -> {
            email.setBody(transformer.apply(email));
            postProcessor.accept(email);
        });

        LOGGER.info("Finished processing emails");
    }

    private static void validateForNull(boolean emails, String message) {
        if (emails) {
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
    }
}
