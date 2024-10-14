package Sprint_2.BJS2_33723;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> emailConsumer, Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                transformer.apply(email);
                emailConsumer.accept(email);
            }
        }
    }
}
