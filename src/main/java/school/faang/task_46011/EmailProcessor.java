package school.faang.task_46011;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> converter,
                              Consumer<Email> consumer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String converted = converter.apply(email);
                email.setBody(converted);
                consumer.accept(email);
            }
        }
    }
}
