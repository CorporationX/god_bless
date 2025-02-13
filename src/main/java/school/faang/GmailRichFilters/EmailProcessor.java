package school.faang.GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> action, Function<Email, String> transformer) {

        for (Email email : emails) {
            if (filter.test(email)) {
                String transformBody = transformer.apply(email);
                email.setBody(transformBody);
                action.accept(email);
            }
        }
    }
}