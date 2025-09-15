package school.faang.lambda.bjs2_87321;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(@NonNull List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> transformer, Consumer<Email> action) {
        if (!emails.isEmpty()) {
            for (Email email : emails) {
                if (filter.test(email)) {
                    action.accept(email);
                    email.setBody(transformer.apply(email));
                }
            }
        }
    }
}