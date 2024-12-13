package school.faang.task_45909;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> listOfMails,
                              Predicate<Email> filter,
                              Function<Email, String> transformer,
                              Consumer<Email> action) {

        for (Email email : listOfMails) {
            if (filter.test(email)) {
                String transformed = transformer.apply(email);
                email.setBody(transformed);
                action.accept(email);
            }
        }
    }
}
