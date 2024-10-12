package school.faang.BJS2_33636_GmailRichFilters;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> emailBodyMapper,
                              Consumer<Email> consumer) {
        Objects.requireNonNull(emails, "List of emails can't be null.");
        emails.forEach(this::validateEmail);
        filter = Objects.requireNonNullElse(filter, email -> true);
        emailBodyMapper = Objects.requireNonNullElse(emailBodyMapper, Email::getBody);
        consumer = Objects.requireNonNullElse(consumer, email ->
                System.out.printf("Message with subject %s has been processed\n", email.getSubject())
        );

        for (Email email: emails) {
            if (filter.test(email)) {
                email.setBody(emailBodyMapper.apply(email));
                consumer.accept(email);
            }
        }
    }

    private void validateEmail(Email email) {
        if (email == null) {
            throw new IllegalArgumentException("Email can't be null.");
        }
    }
}
