package faang.school.godbless;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    @NonNull
    public void processEmails(
            List<Email> emails, Predicate<Email> predicate,
            Consumer<Email> consumer, Function<Email, String> function) {

        emails.stream().forEach(email -> {
            predicate.test(email);
            consumer.accept(email);
            function.apply(email);
        });
    }
}
