package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> handler,
                              Function<Email, String> converter) {
        if (emails.isEmpty() || filter == null || handler == null || converter == null) {
            throw new IllegalArgumentException();
        }
        emails.forEach(email -> {
            if (filter.test(email)) {
                email.setBody(converter.apply(email));
                handler.accept(email);
            }
        });
    }
}
