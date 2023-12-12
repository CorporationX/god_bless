package faang.school.godbless.BJS2_793;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> importantFilter, Consumer<Email> action, Function<Email, String> transformer) {
        emails.forEach(email -> {
            if (importantFilter.test(email)) {
                email.setBody(transformer.apply(email));
                action.accept(email);
            }
        });
    }
}