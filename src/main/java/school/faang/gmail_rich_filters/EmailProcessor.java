package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transformer,
                              Consumer<Email> emailConsumer) {

        emails.stream()
                .filter(filter)
                .map(email -> {
                    String transformedBody = transformer.apply(email);
                    email.setBody(transformedBody);
                    return email;
                })
                .forEach(emailConsumer);
    }
}