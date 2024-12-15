package school.faang.sprint2.task_4;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> transformer) {
        if (emails == null) {
            throw new IllegalArgumentException("Emails cannot be null");
        }
        String transformedBody;
        for (Email email : emails) {
            if (filter.test(email)) {
                transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                action.accept(email);
            }
        }
    }
}
