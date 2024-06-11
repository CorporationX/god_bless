package BJS2_9315;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> handler, Function<Email, String> transformer) {
        List<Email> filterEmails = emails.stream().filter(filter).toList();

        filterEmails.stream()
                .peek(email -> email.setBody(transformer.apply(email)))
                .forEach(handler::accept);
    }
}