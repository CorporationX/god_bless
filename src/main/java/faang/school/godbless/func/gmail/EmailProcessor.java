package faang.school.godbless.func.gmail;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public record EmailProcessor() {

    public Map<String, String> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> transformer) {
        if (emails == null || emails.isEmpty()) {
            throw new IllegalArgumentException("Nothing to process here.");
        }
        return emails.stream()
                .filter(filter)
                .peek(handler)
                .collect(Collectors.toMap(Email::subject, transformer));
    }
}
