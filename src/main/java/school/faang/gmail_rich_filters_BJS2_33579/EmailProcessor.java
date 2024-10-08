package school.faang.gmail_rich_filters_BJS2_33579;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> emailProcessor,
                              Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformer.apply(email));
                emailProcessor.accept(email);
            }
        }
    }
}
