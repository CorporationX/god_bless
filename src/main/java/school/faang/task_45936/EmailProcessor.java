package school.faang.task_45936;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transformation,
                              Consumer<Email> consumer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = transformation.apply(email);
                email = new Email(email.subject(), transformedBody, email.isImportant());
                consumer.accept(email);
            }
        }
    }
}
