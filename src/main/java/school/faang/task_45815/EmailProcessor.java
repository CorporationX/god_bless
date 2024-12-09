package school.faang.task_45815;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> processEmail, Function<Email, String> transformBody) {
        if (emails == null) {
            throw new IllegalArgumentException("List of emails cannot be null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Predicate<Email> filter cannot be null");
        }
        if (processEmail == null) {
            throw new IllegalArgumentException("Consumer<Email> processEmail cannot be null");
        }
        if (transformBody == null) {
            throw new IllegalArgumentException("Function<Email, String> transformBody cannot be null");
        }
        emails.forEach(email -> {
            if(filter.test(email)) {
                String body = transformBody.apply(email);
                email.setBody(body);
                processEmail.accept(email);
            }
        });
    }
}
