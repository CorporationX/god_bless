package faang.school.godbless.BJS2_9364;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmail(List<Email> emails, Predicate<Email> filter, Consumer<Email> action, Function<Email, String> function) {
        emails.stream().filter(filter).peek(email -> email.setBody(function.apply(email))).peek(action).toList();
    }
}
