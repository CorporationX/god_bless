package school.faang.functionalInterface.gmailFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> function, Consumer<Email> consumer) {
        List<Email> filteredEmails = emails.stream().filter(filter).toList();
        filteredEmails.forEach(email -> {
            email.setBody(function.apply(email));
            consumer.accept(email);
        });
    }
}
