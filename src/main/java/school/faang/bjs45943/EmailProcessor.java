package school.faang.bjs45943;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> modifier, Consumer<Email> action) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                email.setBody(modifier.apply(email));
                action.accept(email);
            }
        });
    }
}
