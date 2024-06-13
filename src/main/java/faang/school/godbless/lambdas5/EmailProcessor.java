package faang.school.godbless.lambdas5;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler,
                              Function<Email, String> converting) {
        emails.forEach((email) -> {
            if (filter.test(email)) {
                converting.apply(email);
            }
            handler.accept(email);
        });
    }
}
