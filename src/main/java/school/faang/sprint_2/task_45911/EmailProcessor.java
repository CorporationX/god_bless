package school.faang.sprint_2.task_45911;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email,
            String> transformer, Consumer<Email> action) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformer.apply(email));
                action.accept(email);
            }
        }
    }
}