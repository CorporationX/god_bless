package school.faang.functional_interfaces_lambdas.gmail_rich_filters_bjs2_87262;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> predicateForEmails,
                              Consumer<Email> emailHandler,
                              Function<Email, String> emailBodyTransformer) {

        for (Email email : emails) {
            if (email != null && predicateForEmails.test(email)) {
                emailHandler.accept(email);
                emailBodyTransformer.apply(email);
            }
        }
    }
}