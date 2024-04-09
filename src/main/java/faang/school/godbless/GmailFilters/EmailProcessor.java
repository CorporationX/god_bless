package faang.school.godbless.GmailFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> action, Function<Email, String> transformer) {
        return emails.stream()
                .filter(filter)
                .peek(action)
                .peek(o -> o.setBody(transformer.apply(o)))
                .collect(Collectors.toList());
    }
}
