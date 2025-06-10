package school.faang.bjs2_79956;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> modifier, Consumer<Email> handler) {
        emails.forEach(email -> {
            filter.test(email);
            modifier.apply(email);
            handler.accept(email);
        });
    }
}
