package faang.school.godbless.BJS2_4997;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(
            List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, Email> converter) {
        for (Email email : emails) {
            if (filter.test(email)) {
                Email transformedEmail = converter.apply(email);
                handler.accept(transformedEmail);
            }
        }
    }
}