package GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProccesor {

    public void processEmails(List<Email> emails, Predicate<Email> emailFilter,
                              Consumer<Email> emailConsumer, Function<Email, String> emailTransform) {
        for (Email email : emails) {
            emailFilter.test(email);
            emailConsumer.accept(email);
            emailTransform.apply(email);
        }
    }
}
