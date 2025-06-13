package school.faang.bjs2_80051;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> handler,
            Function<Email, String> transformer
    ) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformer.apply(email));
                handler.accept(email);
            }
        }
    }
}
