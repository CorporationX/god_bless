package BJS2_21371_GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process,
                                     Function<Email, String> transform) {
        try {
            for (Email email : emails) {
                System.out.println(filter.test(email));
                process.accept(email);
                System.out.println(transform.apply(email));
            }
        } catch (NullPointerException e) {
            System.out.println("Error! Null can't be of any parameter!");
        }

    }
}
