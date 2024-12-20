package school.faang.task_bjs245993;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                String newEmailBody = function.apply(email);
                email.setBody(newEmailBody);
                consumer.accept(email);
            }
        }
    }
}
