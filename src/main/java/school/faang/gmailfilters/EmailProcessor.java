package school.faang.gmailfilters;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@UtilityClass
public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transformer,
                              Consumer<Email> action) {
        filter = Objects.requireNonNullElse(filter, email -> true);
        transformer = Objects.requireNonNullElse(transformer, Email::getBody);
        action = Objects.requireNonNullElse(action, email -> {});

        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformer.apply(email));
                action.accept(email);
            }
        }
    }
}
