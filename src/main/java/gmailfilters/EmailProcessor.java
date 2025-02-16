package gmailfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class EmailProcessor {
    private static final Logger logger = Logger.getLogger(EmailProcessor.class.getName());

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> transformer) {
        if (emails == null || filter == null || transformer == null || action == null) {
            throw new IllegalArgumentException("Arguments cannot be null!");
        }

        for (Email email : emails) {
            try {
                if (email == null) {
                    logger.warning("Encountered null email, skipping!");
                    continue;
                }

                if (filter.test(email)) {
                    String transformedBody = transformer.apply(email);
                    if (transformedBody == null || transformedBody.isBlank()) {
                        logger.warning("Transformed body is empty for email: " + email.subject());
                        continue;
                    }
                    email = new Email(email.subject(), transformedBody, email.isImportant());
                    action.accept(email);
                }
            } catch (Exception e) {
                logger.warning("Error processing email: " + e.getMessage());
            }
        }
    }
}
