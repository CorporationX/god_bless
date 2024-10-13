package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
            Predicate<Email> filter,
            Function<Email, String> changeBody,
            Consumer<Email> showSubject
    ) {
        emails.removeIf(filter);
        emails.forEach(email -> {
            email.setBody(changeBody.apply(email));
            showSubject.accept(email);
        });
    }
}
