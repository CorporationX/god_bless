package school.faang.task_59670;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> transformer) {

        emails.stream()
                .filter(filter)
                .peek(email -> email.setBody(transformer.apply(email)))
                .forEach(action);
    }
}