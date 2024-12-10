package school.faang.task_45822;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(@NonNull List<Email> emails, @NonNull Predicate<Email> filter,
                              @NonNull Function<Email, String> transformer, @NonNull Consumer<Email> action) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                action.accept(email);
            }
        });
    }

}
