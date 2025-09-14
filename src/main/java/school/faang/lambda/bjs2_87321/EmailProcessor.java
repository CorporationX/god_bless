package school.faang.lambda.bjs2_87321;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(@NonNull List<Email> emails, Predicate<Email> predicate,
                              Function<Email, String> function, Consumer<Email> consumer) {
        if (!emails.isEmpty()) {
            for (Email email : emails) {
                if (predicate.test(email)) {
                    consumer.accept(email);
                    email.setBody(function.apply(email));
                }
            }
        }
    }
}