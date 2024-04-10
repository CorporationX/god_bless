package faang.school.godbless.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> incomingEmails, Predicate<Email> filter, Consumer<Email> handler,
                              Function<Email, String> converter) {
        if (incomingEmails == null) {
            throw new NullPointerException("There is no such list");
        }
        if (incomingEmails.isEmpty()) {
            throw new IllegalArgumentException("The list is empty");
        }

        for (Email email : incomingEmails) {
            if (filter.test(email)) {
                handler.accept(email);
                System.out.println(converter.apply(email));
            }
        }
    }
}
