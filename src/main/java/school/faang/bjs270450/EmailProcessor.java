package school.faang.bjs270450;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> transform, Consumer<Email> handler) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String newBody = transform.apply(email);
                email.setBody(newBody);
                handler.accept(email);
            }
        }
    }
}
