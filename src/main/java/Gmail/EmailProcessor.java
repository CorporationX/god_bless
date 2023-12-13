package Gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> treatment,
                              Function<Email, String> transformation) {
        for (Email email : emails) {
            if (filter.test(email)) {
                treatment.accept(email);
                email.setBody(transformation.apply(email));
            }
        }
    }
}
