package school.faang.sprint2.bjs2_57445;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(@NonNull List<Email> emails, @NonNull Predicate<Email> predicate,
                              @NonNull Function<Email, String> transformer, @NonNull Consumer<Email> action) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                email.setBody(transformer.apply(email));
                action.accept(email);
            }
        }
    }
}
