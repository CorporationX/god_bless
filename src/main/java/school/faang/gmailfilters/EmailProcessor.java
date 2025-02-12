package school.faang.gmailfilters;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> filter,
                              Consumer<Email> consumer, Function<Email, String> function) {
        Objects.requireNonNull(emailList, "Email list cannot be null");
        Objects.requireNonNull(filter, "Filter cannot be null");
        Objects.requireNonNull(consumer, "Consumer cannot be null");
        Objects.requireNonNull(function, "Function cannot be null");
        if (emailList.isEmpty()) {
            throw new IllegalArgumentException("Email list is empty");
        }
        emailList.forEach(email -> {
            if (filter.test(email)) {
                email.setBody(function.apply(email));
                consumer.accept(email);
            }
        });
    }
}
