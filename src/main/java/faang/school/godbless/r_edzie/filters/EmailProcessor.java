package faang.school.godbless.r_edzie.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        emails.forEach(email -> {
            predicate.test(email);
            consumer.accept(email);
            function.apply(email);
        });
    }
}
