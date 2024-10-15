package school.faang.secondStream.BJS2_33663;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> transformer) {
        emails.stream().filter(filter).forEach(email -> {
            String transformedBody = transformer.apply(email);
            email.setBody(transformedBody);
            handler.accept(email);
        });
    }
}
