package school.faang.gmailfilter;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Function<Email, String> transformer,
            Consumer<Email> processor
    ) {
        for (Email email : emails) {
            if (filter.test(email)) {
                transformer.apply(email);
                processor.accept(email);
            }
        }
    }
}
