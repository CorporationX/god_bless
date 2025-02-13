package school.faang.BJS2_57418;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> isImportant,
                              Function<Email, String> converter, Consumer<Email> handler) {
        Objects.requireNonNull(emails, "Emails list cannot be null");
        Objects.requireNonNull(isImportant, "Predicate cannot be null");
        Objects.requireNonNull(converter, "Function cannot be null");
        Objects.requireNonNull(handler, "Consumer cannot be null");

        for (Email email : emails) {
            if (isImportant.test(email)) {
                converter.apply(email);
                handler.accept(email);
            }
        }
    }
}
