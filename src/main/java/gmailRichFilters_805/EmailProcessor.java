package gmailRichFilters_805;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void isImportant(List<Email> emails, Predicate<Email> predicate,
                            Consumer<Email> consumer, Function<Email, Email> function) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                consumer.accept(email);
                function.apply(email);
            }
        }
    }
}