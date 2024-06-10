package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processing,
                              Function<Email, String> transforming) {
        emails.stream().filter(filter).peek(processing).
                forEach(email -> email.setBody(transforming.apply(email)));
    }
}
