package faang.school.godbless.gmailRichFilters;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    public Map<String, String> processEmails(List<Email> email, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Nothing to process here.");
        }
        return email.stream()
                .filter(predicate)
                .peek(consumer)
                .collect(Collectors.toMap(Email::getSubject, function));
    }
}
