package BJS2_21371_GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process,
                                     Function<Email, String> transform) {
        if (emails != null) {
            for (Email email : emails) {
                if (filter.test(email)) {
                    transform.apply(email);
                    System.out.println(email.getBody());
                    process.accept(email);
                }
            }
        } else {
            System.out.println("Error! Null can't be of any parameter!");
        }
    }
}
