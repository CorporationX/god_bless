package school.faang.task_45764;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> transformation, Consumer<Email> processing) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setSubject(transformation.apply(email));
                processing.accept(email);
            }
        }
    }
}
