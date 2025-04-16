package school.faang.bjs270517;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Function<Email, String> bodyModifier,
            Consumer<Email> processor
    ) {
        emails.stream().filter(filter).forEach((email) -> {
            email.setBody(bodyModifier.apply(email));
            processor.accept(email);
        });
    }
}
