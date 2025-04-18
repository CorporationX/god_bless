package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> bodyTransformer,
                              Consumer<Email> emailConsumer) {

        emails.stream()
                .filter(filter)
                .peek(email -> {
                    String transformedBody = bodyTransformer.apply(email);
                    email.setBody(transformedBody);
                })
                .forEach(emailConsumer);
    }
}