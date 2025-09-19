package school.faang.sprint2.gmail.rich.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> emailConsumer,
                              Function<Email, String> bodyTransformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                continue;
            }
            String transformedBody = bodyTransformer.apply(email);

            email.setBody(transformedBody);

            emailConsumer.accept(email);
        }
    }
}
