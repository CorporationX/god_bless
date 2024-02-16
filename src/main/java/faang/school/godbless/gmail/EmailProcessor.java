package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailFilter, Consumer<Email> handler, Function<Email, String> transformer) {
        emails.forEach(email -> {
            if (emailFilter.test(email)) {
                handler.accept(email);
                transformer.apply(email);
            }
        });
    }
}
