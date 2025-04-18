package school;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> process,
                              Function<Email, String> convert) {
        emails.stream()
                .filter(filter)
                .forEach(email -> {
                    convert.apply(email);
                    process.accept(email);
                });
    }
}

