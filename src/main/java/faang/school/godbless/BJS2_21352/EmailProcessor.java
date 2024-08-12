package faang.school.godbless.BJS2_21352;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        emails.forEach(email -> {
            if (!predicate.test(email)) {
                String text = function.apply(email);
                email.setBody(text);
                consumer.accept(email);
            }
        });
    }
}
