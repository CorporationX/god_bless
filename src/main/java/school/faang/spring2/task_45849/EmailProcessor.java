package school.faang.spring2.task_45849;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> predicate,
                              Function<Email, String> function,
                              Consumer<Email> consumer) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                String text = function.apply(email);
                email.setBody(text);
                consumer.accept(email);
            }
        }
    }
}
