package school.faang.task_45981;

import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> consumer,
                              Function<Email, String> function) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String message = function.apply(email);
                email.setBody(message);
                consumer.accept(email);
            }
        }

    }

}
