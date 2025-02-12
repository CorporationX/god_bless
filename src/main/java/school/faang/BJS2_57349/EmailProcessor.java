package school.faang.BJS2_57349;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class EmailProcessor {

    public void processEmails(
            List<Email> emails,
            Predicate<Email> shouldRemove,
            Consumer<Email> processAction,
            Function<Email, String> updateBody
    ) {
        emails.removeIf(email -> shouldRemove.test(email));
        emails.forEach(email -> {
            processAction.accept(email);
            email.setBody(updateBody.apply(email));
        });
    }
}
