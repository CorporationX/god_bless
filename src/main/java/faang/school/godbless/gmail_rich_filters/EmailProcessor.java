package faang.school.godbless.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emailsList,
            Predicate<Email> filter,
            Consumer<Email> consumer,
            Function<Email, String> function
    ) {
        for (Email email : emailsList) {
            if (filter.test(email)) {
                consumer.accept(email);
                email.setBody(function.apply(email));
            }
        }
    }
}
