package school.faang.bjs2_87315;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> function) {
        emails.forEach((email -> {
            if (filter.test(email)) {
                action.accept(email);
                String edited = function.apply(email);
                email.setBody(edited);
            }
        }));

    }
}
