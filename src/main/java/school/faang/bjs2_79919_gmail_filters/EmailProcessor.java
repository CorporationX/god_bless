package school.faang.bjs2_79919_gmail_filters;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> announce,
            Function<Email, String> transform
    ) {
        if (filter == null || announce == null || transform == null) {
            throw new IllegalArgumentException("Processor functions cannot be null");
        }
        if (emails == null) {
            return;
        }

        emails.forEach(email -> {
            announce.accept(email);
            if (filter.test(email)) {
                log.info("Transforming email {}", email.getSubject());
                transform.apply(email);
            } else {
                log.info("Skipping email {}", email.getSubject());
            }
        });
    }
}
