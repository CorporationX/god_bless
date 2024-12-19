package school.faang.bjs245862;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> predicate,
                              Function<Email, String> func,
                              Consumer<Email> consumer) {

        emails.forEach(email -> {
            if (predicate.test(email)) {
                String textModification = func.apply(email);
                email.setBody(textModification);
                consumer.accept(email);
            }
        });
    }
}