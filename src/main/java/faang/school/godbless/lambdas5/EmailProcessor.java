package faang.school.godbless.lambdas5;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler,
                              Function<Email, String> converting) {
        emails.forEach((email) -> {
            filter.test(email);
            handler.accept(email);
            converting.apply(email);
        });
    }
}
