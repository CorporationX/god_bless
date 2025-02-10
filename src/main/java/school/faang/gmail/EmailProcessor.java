package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> incomingMessages, Predicate<Email> filter,
                             Function<Email, String> converter, Consumer<Email> handler) {
        for (Email email : incomingMessages) {
            if (filter.test(email)) {
                String resultEmailBody = converter.apply(email);
                email.setBody(resultEmailBody);
                handler.accept(email);
            }
        }
    }
}
