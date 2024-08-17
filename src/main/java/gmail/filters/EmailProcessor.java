package gmail.filters;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(@NonNull List<Email> emails,
                              @NonNull Predicate<Email> predicateFilter,
                              @NonNull Consumer<Email> consumerFilter,
                              @NonNull Function<Email, Email> functionFilter) {
        emails.forEach(email -> {
            if (predicateFilter.test(email)) {
                consumerFilter.accept(functionFilter.apply(email));
            }
        });
    }
}
