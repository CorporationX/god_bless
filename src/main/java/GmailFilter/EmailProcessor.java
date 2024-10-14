package GmailFilter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> emailModifier,
                              Consumer<Email> emailConsumer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                emailConsumer.accept(email);
                email.setBody(emailModifier.apply(email));
            }
        }
    }
}
