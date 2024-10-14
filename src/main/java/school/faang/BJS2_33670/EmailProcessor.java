package school.faang.BJS2_33670;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> transformer, Consumer<Email> processor) {
        emails.stream()
            .filter(filter)
            .forEach(processor);
    }
}
