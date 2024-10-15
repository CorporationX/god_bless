package school.faang.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    // Method to filter, transform, and process emails
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> action,
                              Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) { // 1. Filter emails using Predicate
                String transformedBody = transformer.apply(email); // 2. Transform email body using Function
                email.setBody(transformedBody); // Update email body
                action.accept(email); // 3. Perform action on the email using Consumer
            }
        }
    }
}
