package school.faang.task_45974;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    protected void processEmails(List<Email> emails,
                               Predicate<Email> filter,
                               Consumer<Email> processor,
                               Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedEmail = transformer.apply(email);
                email.setBody(transformedEmail);
                processor.accept(email);
            }
        }
    }
}
