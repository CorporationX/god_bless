package school.faang.task_45830;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> action, Function<Email, String> transformer) {
        if (emails == null || emails.isEmpty()) {
            throw new IllegalArgumentException("Список писем пуст или null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("filter null");
        }
        if (action == null) {
            throw new IllegalArgumentException("action null");
        }
        if (transformer == null) {
            throw new IllegalArgumentException("transformer null");
        }
        emails.stream().filter(filter).peek(email -> email.setBody(transformer.apply(email))).forEach(action);
    }
}
