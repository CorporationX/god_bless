package school.faang.bjs2_71941;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> modifier) {
        emails.stream()
                .filter(predicate)
                .forEach(email -> {
                    String modifiedBody = modifier.apply(email);
                    email.setBody(modifiedBody);
                    consumer.accept(email);
                });
    }
}
