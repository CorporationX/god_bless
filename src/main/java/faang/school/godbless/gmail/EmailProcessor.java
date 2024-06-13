package faang.school.godbless.gmail;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    public Map<String, String> processEmails(List<Email> emails, Predicate<Email> filter,
                                             Consumer<Email> handler, Function<Email, String> converter) {
        return emails.stream()
                .filter(filter)
                .peek(handler)
                .collect(Collectors.toMap(Email::getSubject, converter));
    }
}
