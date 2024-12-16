package school.faang.task_46003;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> transform) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String updatedBody = transform.apply(email);
                email.setBody(updatedBody);
                action.accept(email);
            }
        }
    }
}
