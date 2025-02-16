package bjs257436;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler,
                              Function<Email, String> converter) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                handler.accept(email);
                String convertedLetter = converter.apply(email);
                email.setBody(convertedLetter);
            }
        });
    }
}
