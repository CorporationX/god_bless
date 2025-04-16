package school.faang.bjs2_70500;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> action,
            Function<Email, String> transformer
    ) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformer.apply(email));
                action.accept(email);
            }
        }
    }
}
