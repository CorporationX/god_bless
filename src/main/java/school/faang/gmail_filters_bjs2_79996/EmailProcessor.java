package school.faang.gmail_filters_bjs2_79996;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                                     Consumer<Email> action, Function<Email, String> transformer) {
        List<Email> result = new ArrayList<>();
        for (Email email : emails) {
            if (predicate.test(email)) {
                String newBody = transformer.apply(email);
                email.setBody(newBody);
                action.accept(email);
                result.add(email);
            }
        }
    }
}
