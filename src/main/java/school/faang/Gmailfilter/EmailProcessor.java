package school.faang.Gmailfilter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transform,
                              Consumer<Email> processor) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = transform.apply(email);
                email = new Email(email.getSubject(), transformedBody, email.isImportant());
                processor.accept(email);
            }
        }
    }
}
