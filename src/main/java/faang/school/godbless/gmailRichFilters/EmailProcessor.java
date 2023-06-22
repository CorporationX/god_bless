package faang.school.godbless.gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> handler, Function<Email, String> converter) {
        for (Email currentEmail : emails) {
            if (filter.test(currentEmail)) {
                handler.accept(currentEmail);
                converter.apply(currentEmail);
            }
        }
    }
}
