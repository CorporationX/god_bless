package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> consumer, Function<Email, String> handler) {
        if (emails != null) {
            emails.stream().filter(filter).map(e -> {
                e.setBody(handler.apply(e));
                return e;
            }).forEach(consumer);
        }
    }
}
