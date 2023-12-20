package gmailRichFilters_805;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void isImportant(List<Email> emails, Predicate<Email> predicate,
                            Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                Email transforEmail = new Email(email.getSubject(), function.apply(email),email.isImportant());
                consumer.accept(transforEmail);
            }
        }
    }
}