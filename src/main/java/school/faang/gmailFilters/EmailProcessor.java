package school.faang.gmailFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmail(List<Email> emails, Predicate<Email> filter,
                             Function<Email, String> function, Consumer<Email> handler) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = function.apply(email);
                email.setBody(transformedBody);
                handler.accept(email);
            }
        }
    }
}
