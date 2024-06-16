package faang.school.godbless.BJS2_9796;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        if (emails != null && !emails.isEmpty() &&
                predicate != null && consumer != null &&
                function != null) {
            for (Email email : emails) {
                if (predicate.test(email)) {
                    consumer.accept(email);
                    System.out.println(function.apply(email));
                }
            }
        }
    }
}
