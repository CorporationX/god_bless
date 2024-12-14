package school.faang.moduleone.sprinttwo.task_43527;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, Email> mapper,
                              Consumer<Email> handler) {
        emails.stream()
                .filter(filter)
                .map(mapper)
                .forEach(handler);
    }
}
