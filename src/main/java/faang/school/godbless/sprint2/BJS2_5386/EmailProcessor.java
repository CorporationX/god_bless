package faang.school.godbless.sprint2.BJS2_5386;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        emails.forEach((Email email) -> {
            if (predicate.test(email)) {
                consumer.accept(email);
                email.setBody(function.apply(email));
            }
        });
    }
}
