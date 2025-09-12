package school.faang.bjs2_87295;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    void processEmails(List<Email> emails, Predicate<Email> filter,
                       Consumer<Email> handler, Function<Email, String> converter) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(converter.apply(email));
                handler.accept(email);
            }
        }
    }
}
