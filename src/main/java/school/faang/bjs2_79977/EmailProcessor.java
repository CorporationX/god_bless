package school.faang.bjs2_79977;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transformer,
                              Consumer<Email> handler) {

        emails.stream()
                .filter(filter)
                .map(email -> {
                    String newBody = transformer.apply(email);
                    email.setBody(newBody);
                    return email;
                })
                .forEach(handler);
    }
}
