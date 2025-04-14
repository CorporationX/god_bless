package school.faang.bjs2_70414;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
        List<Email> emails,
        Predicate<Email> filter,
        Consumer<Email> print,
        Function<Email, String> toUpperCase
    ) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                toUpperCase.apply(email);
                print.accept(email);
            }
        });
    }
}
