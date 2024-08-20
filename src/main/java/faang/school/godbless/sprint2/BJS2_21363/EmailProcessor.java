package faang.school.godbless.sprint2.BJS2_21363;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    protected void processEmails(
            @NonNull List<Email> emails,
            @NonNull Predicate<Email> filter,
            @NonNull Consumer<Email> consumer,
            @NonNull Function<Email, String> function
    ) {
        emails.forEach((email) -> {
            filter.test(email);
            System.out.println(function.apply(email));
            consumer.accept(email);
        });
    }
}