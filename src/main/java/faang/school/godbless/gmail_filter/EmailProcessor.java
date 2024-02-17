package faang.school.godbless.gmail_filter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> consumer, Function<Email, Email> function) {

        for (Email email : emails) {
            if (filter.test(email)) {
                consumer.accept(function.apply(email));
            }
        }
    }
}
