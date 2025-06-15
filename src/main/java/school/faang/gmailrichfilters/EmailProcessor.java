package school.faang.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> function,
                              Consumer<Email> consumer) {
        emails.stream().filter(filter)
                .map(email -> {
                    email.setBody(function.apply(email));
                    return email;
                }).forEach(consumer);
    }
}
