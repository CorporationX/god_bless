package school.faang.gmail_filters_bjs2_79996;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> predicate,
                                     Consumer<Email> consumer, Function<Email, String> function) {
        List<Email> result = new ArrayList<>();
        for (Email email : emails) {
            if (predicate.test(email)) {
                String newBody = function.apply(email);
                email.setBody(newBody);
                consumer.accept(email);
                result.add(email);
            }
        }
        return result;
    }
}
