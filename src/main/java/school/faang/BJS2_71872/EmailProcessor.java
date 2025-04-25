package school.faang.BJS2_71872;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Function<Email, String> convert,
            Consumer<Email> process) {
        emails.stream()
                .filter(filter)
                .peek(email -> email.setBody(convert.apply(email)))
                .forEach(process);
    }
}