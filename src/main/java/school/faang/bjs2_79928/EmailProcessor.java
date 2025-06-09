package school.faang.bjs2_79928;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> action, Consumer<Email> handler) {
        for (Email email : emails) {
            if (email.hasContent() && filter.test(email)) {
                email.setBody(action.apply(email));
                handler.accept(email);
            }
        }
    }
}
