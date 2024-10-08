package school.faang.gmailFilter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> consumer,
            Function<Email, String> function
    ) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                consumer.accept(email);
                function.apply(email);
            }
        });
    }
}
