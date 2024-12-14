package faang.school.godbless.aged777_BJS2_9454_gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email currentEmail : emails) {
            if (predicate.test(currentEmail)) {
                consumer.accept(currentEmail);
                function.apply(currentEmail);
            }
        }
    }
}
