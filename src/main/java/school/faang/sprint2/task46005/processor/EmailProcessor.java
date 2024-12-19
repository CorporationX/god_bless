package school.faang.sprint2.task46005.processor;

import school.faang.sprint2.task46005.model.Email;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                action.accept(email);
            }
        }

    }
}