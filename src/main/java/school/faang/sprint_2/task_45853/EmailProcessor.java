package school.faang.sprint_2.task_45853;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> converter,
                              Consumer<Email> action) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String newBody = converter.apply(email);
                email.setBody(newBody);
                action.accept(email);
            }
        }
    }
}
