package school.faang.bjs2_70556;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> modify,
                              Consumer<Email> process) {
        emails.forEach(email -> {
            if (!filter.test(email)) {
                return;
            }
            email.setBody(modify.apply(email));
            process.accept(email);
        });
    }
}
