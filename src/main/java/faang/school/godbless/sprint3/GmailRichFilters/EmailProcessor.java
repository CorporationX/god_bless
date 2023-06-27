package faang.school.godbless.sprint3.GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> handler,
            Function<Email, String> converter
    ) {
        for (Email email: emails) {
            String newEmail;
            if (filter.test(email)) {
                handler.accept(email);
                newEmail = converter.apply(email);
            }
        }
    }
}
