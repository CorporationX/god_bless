package school.faang.sprint_2.task_43527_Gmail_Rich_Filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> convertor,
                              Consumer<Email> handler) {
        emails.stream()
                .filter(filter)
                .forEach(email -> {
                    convertor.apply(email);
                    handler.accept(email);
                });
    }
}
