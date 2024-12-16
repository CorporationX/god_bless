package school.faang.sprint1.sprint2.task_45968;

import java.util.function.Predicate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> processor,
                              Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String newBody = transformer.apply(email);
                email.setBody(newBody);
                processor.accept(email);

            }
        }

    }
}
