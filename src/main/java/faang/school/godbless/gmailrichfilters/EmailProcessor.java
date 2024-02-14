package faang.school.godbless.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processor, Function<Email, String> refactoring) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                processor.accept(email);
                refactoring.apply(email);
            }
        });
    }
}
