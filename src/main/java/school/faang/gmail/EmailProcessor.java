package school.faang.gmail;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> function,
                              Consumer<Email> consumer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(function.apply(email));
                consumer.accept(email);
            }
        }
    }
}
