package faang.school.godbless.Gmail_Rich_Filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> converter) {
        for (Email email : emails) {
            filter.test(email);
            handler.accept(email);
            converter.apply(email);
        }
    }
}
