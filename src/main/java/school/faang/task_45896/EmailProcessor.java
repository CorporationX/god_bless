package school.faang.task_45896;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> incomingEmails, Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> transformer) {
        for (Email email : incomingEmails) {
            if (filter.test(email)) {
                String transformedBody = transformer.apply(email);
                System.out.println(transformedBody);
                action.accept(email);
            }
        }
    }
}
