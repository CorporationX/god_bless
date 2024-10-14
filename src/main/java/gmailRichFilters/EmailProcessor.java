package gmailRichFilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static List<Email> processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Function<Email, String> transformer,
            Consumer<Email> consumer
    ) {
        List<Email> filteredEmails = new ArrayList<>();

        emails.forEach(email -> {
            if (filter.test(email)) {
                transformer.apply(email);
                filteredEmails.add(email);
                consumer.accept(email);
            }
        });

        return filteredEmails;
    }
}
