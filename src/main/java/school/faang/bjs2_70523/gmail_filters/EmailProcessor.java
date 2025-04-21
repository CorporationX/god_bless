package school.faang.bjs2_70523.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> predicate,
                              Consumer<Email> consumer,
                              Function<Email, String> function) {
        emails.forEach(email -> {
            if (predicate == null || predicate.test(email)) {
                if (function != null) {
                    email.setBody(function.apply(email));
                }
                if (consumer != null) {
                    consumer.accept(email);
                }
            }
        });
    }
}
