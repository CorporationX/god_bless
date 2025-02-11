package school.faang.gmailfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> filter,
                              Consumer<Email> consumer, Function<Email, String> function) {
        if (filter == null || consumer == null || function == null) {
            throw new NullPointerException("One of the functions is null");
        } else if (emailList.isEmpty()) {
            throw new IllegalArgumentException("Email list is empty");
        }
        emailList.forEach(email -> {
            if (filter.test(email)) {
                email.setBody(function.apply(email));
                function.apply(email);
                consumer.accept(email);
            }
        });
    }
}
