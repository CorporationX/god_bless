package school.faang.task_57464;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(
            @NonNull List<Email> emails,
            @NonNull Predicate<Email> filter,
            @NonNull Consumer<Email> handler,
            @NonNull Function<Email, String> converter
    ) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String convertedBody = converter.apply(email);
                email.setBody(convertedBody);
                handler.accept(email);
            }
        }
    }
}
