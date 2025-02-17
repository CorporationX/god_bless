package school.faang.task_59633;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(@NonNull List<Email> incomingEmails, @NonNull Predicate<Email> filter,
                              @NonNull Function<Email, String> refactor, @NonNull Consumer<Email> action) {
        for (Email email : incomingEmails) {
            if (filter.test(email)) {
                String refactoredBody = refactor.apply(email);
                email.setBody(refactoredBody);
                action.accept(email);
            }
        }
    }
}
