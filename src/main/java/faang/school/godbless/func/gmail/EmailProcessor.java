package faang.school.godbless.func.gmail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public record EmailProcessor() {

    public Map<String, String> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> transformer) {
        if (emails == null || emails.isEmpty()) {
            throw new IllegalArgumentException("Nothing to process here.");
        }
        Map<String, String> importantBits = new HashMap<>();
        emails.forEach(email -> {
            if (filter.test(email)) {
                handler.accept(email);
                importantBits.put(email.subject(), transformer.apply(email));
            }
        });
        return importantBits;
    }
}
