package school.faang.stream2.gmailrichfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public List<Email> processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> transform,
                              Function<Email, String> process) {
        List<Email> result = new ArrayList<>();
        emails.forEach(email -> {
            if (filter.test(email)) {
                transform.accept(email);
                process.apply(email);
                result.add(email);
            }
        });
        return result;
    }
}
