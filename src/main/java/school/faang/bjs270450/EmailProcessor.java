package school.faang.bjs270450;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transform,
                              Consumer<Email> handler) {
        emails.stream()
                .filter(filter)
                .forEach(email -> {
                    email.setBody(transform.apply(email));
                    handler.accept(email);
                });
    }
}