package GmailFilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Emailprocessor {
    public static void processEmails(List<Email> emails, Function<Email, String> transform, Predicate<Email> filter, Consumer<Email> operation) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transform.apply(email));
                operation.accept(email);
                System.out.println(email.getBody());
            }
        }
    }
}
