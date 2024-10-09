package school.faang.task214.Emails;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(Email email, Predicate<Email> predicate, Function<Email, String> function, Consumer<Email> consumer) {
        if (predicate.test(email)) {
            email.setBody(function.apply(email));
            consumer.accept(email);
        }
    }
}
