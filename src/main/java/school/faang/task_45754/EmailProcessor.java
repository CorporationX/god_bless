package school.faang.task_45754;

import school.faang.task_45754.model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> action,
            Function<Email, Email> transformer
    ) {
        List<Email> newEmails = new ArrayList<>();

        emails.forEach(email -> {
            if (filter.test(email)) {
                action.accept(email);
                Email newEmail = transformer.apply(email);
                newEmails.add(newEmail);
            }
        });

        return newEmails;
    }
}
