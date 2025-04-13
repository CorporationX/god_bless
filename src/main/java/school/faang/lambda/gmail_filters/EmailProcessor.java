package school.faang.lambda.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> printer,
                              Function<Email, String> transformer) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                printer.accept(email);
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
            }
        });
    }
}
