package gmail.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> predicate,
            Consumer<Email> consumer,
            Function<Email, String> function) {

        for (Email email: emails) {
            if (predicate.test(email)) {
                System.out.printf("Письмо '%s' является очень важным", email.getSubject()).println();
            }
            email.setBody(function.apply(email));
            consumer.accept(email);
        }
    }
}
