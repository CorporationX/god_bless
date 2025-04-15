package gmail.rich.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailFilter,
                              Function<Email, Email> emailEditor, Consumer<Email> emailHandler) {
        emails.stream()
                .filter(emailFilter)
                .map(emailEditor)
                .forEach(emailHandler);
    }
}
