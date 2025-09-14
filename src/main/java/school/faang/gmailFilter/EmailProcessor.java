package school.faang.gmailFilter;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.List;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> consumer,
                              Function<Email, String> mapper) {
        for (Email email : emails) {
            if (filter.test(email)) {
                mapper.apply(email);
                consumer.accept(email);
            }
        }
    }
}
