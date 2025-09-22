package school.faang.email.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter,
                                     Consumer<Email> emailHandler, Function<Email, String> emailTransformer) {
        return emails.stream()
                .filter(filter)
                .peek(email -> {
                    email.setBody(emailTransformer.apply(email));
                    emailHandler.accept(email);
                })
                .toList();
    }
}
