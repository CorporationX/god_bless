package faang.school.godbless.gmailFilt;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, Email> function) {
        emails.removeIf(email -> !email.isImportant());
        emails.forEach(consumer);
        emails.forEach(function::apply);
    }
}
