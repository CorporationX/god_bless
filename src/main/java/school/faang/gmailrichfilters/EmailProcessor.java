package school.faang.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> emailFilter,
                              Function<Email, String> bodyTransformer,
                              Consumer<Email> emailConsumer) {
        if (emails == null || emailFilter == null || bodyTransformer == null || emailConsumer == null) {
            throw new IllegalArgumentException("The email list, email filter, body transformer and email consumer " +
                    "must not be null!");
        }
        emails.stream()
                .filter(emailFilter)
                .forEach(email -> {
                    email.setBody(bodyTransformer.apply(email));
                    emailConsumer.accept(email);
                });
    }
}
