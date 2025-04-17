package school.faang.stream2.gmailrichfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> predicate,
                              Consumer<Email> consumer,
                              Function<Email, String> function) {
        List<Email> result = new ArrayList<>();
        emails.forEach(email -> {
            if (predicate.test(email)) {
                function.apply(email);
                consumer.accept(email);
                result.add(email);
            }
        });
        emails.clear();
        emails.addAll(result);
    }
}
