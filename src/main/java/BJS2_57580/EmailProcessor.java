package BJS2_57580;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> mapper,
                              Consumer<Email> action
    ) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String data = mapper.apply(email);
                email.setBody(data);
                action.accept(email);
            }
        }
    }
}
