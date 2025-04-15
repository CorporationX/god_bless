package school.faang.gmailfilter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(Predicate<Email> predicate, Function<Email, String> function,
                              Consumer<Email> consumer, List<Email> emails) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                String newBody = function.apply(email);
                email.setBody(newBody);
                consumer.accept(email);
            }
        }
    }
}
