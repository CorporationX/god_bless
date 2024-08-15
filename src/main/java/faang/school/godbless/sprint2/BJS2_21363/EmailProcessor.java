package faang.school.godbless.sprint2.BJS2_21363;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    protected void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> consumer,
            Function<Email, String> function
    ) {
        Objects.requireNonNull(emails);
        Objects.requireNonNull(filter);
        Objects.requireNonNull(consumer);
        Objects.requireNonNull(function);

        emails.forEach((email) -> {
            filter.test(email);
            consumer.accept(email);
            System.out.println(function.apply(email));
        });
    }
}