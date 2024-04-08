package faang.school.godbless.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public List<String> processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> handler,
            Function<Email, String> function
    ) {
        return emails.stream()
                .filter(filter)
                .peek(handler)
                .map(function)
                .toList();
    }
}