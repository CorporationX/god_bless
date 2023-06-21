package faang.school.godbless.sprint_3.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public static List<Email> processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, Email> function) {
        return emails.stream()
                .filter(predicate)
                .peek(consumer)
                .map(function)
                .toList();
    }
}
