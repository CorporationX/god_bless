package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Consumer<Email> action, Function<Email, String> transformer) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                action.accept(email);
            }
        }
    }
}
