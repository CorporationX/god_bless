package school.faang.gmailRichFilters;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> handler, Function<Email, String> transformer) {
        Objects.requireNonNull(filter);
        Objects.requireNonNull(handler);
        Objects.requireNonNull(transformer);

        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                handler.accept(email);
            }
        }
    }
}
