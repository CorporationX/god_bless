package school.faang.bjs2_71547;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Function<Email, String> function, Consumer<Email> printer) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                email.setBody(function.apply(email));
                printer.accept(email);
            }
        }
    }
}
