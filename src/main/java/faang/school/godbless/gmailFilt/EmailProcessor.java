package faang.school.godbless.gmailFilt;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, Email> function) {
        for (int i = 0; i < emails.size(); i++) {
            if (predicate.test(emails.get(i))) {
                emails.set(i, function.apply(emails.get(i)));
                consumer.accept(emails.get(i));
            }
        }
    }
}
