package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmail(List<Email> emails, Predicate<Email> filter, Consumer<Email> action, Function<Email, String> function) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                email.setBody(function.apply(email));
                action.accept(email);
            }
        });
    }
}
