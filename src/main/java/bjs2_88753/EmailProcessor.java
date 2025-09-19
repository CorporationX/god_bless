package bjs2_88753;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class EmailProcessor {

    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> action,
            Function<Email, String> transformer
    ) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String newBody = transformer.apply(email);
                email.setBody(newBody);
                action.accept(email);
            }
        }
    }
}