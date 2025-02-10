package school.faang.task_57236;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> listEmail, Predicate<Email> predicate,
                              Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : listEmail) {
            if (predicate.test(email)) {
                String message = function.apply(email);
                email.setBody(message);
                consumer.accept(email);

            }
        }
    }
}
