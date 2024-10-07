package school.faang.gmailfilter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processing, Function<Email, String> transformation) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                email.setBody(transformation.apply(email));
                processing.accept(email);
            }
        });
    }
}
