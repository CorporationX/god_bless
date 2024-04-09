package faang.school.godbless.GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emails) {
            if (filter.test(email)) {
                consumer.accept(email);
                String transformedBody = function.apply(email);
                System.out.println("Proceeded email body: " + transformedBody);
            }
        }
    }
}
