package school.faang.bjs2_87305;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> consumer,
            Function<Email, String> transformer) {

        for (Email email : emails) {
            if (filter.test(email)) {
                transformer.apply(email);
                consumer.accept(email);
            }
        }
    }
}